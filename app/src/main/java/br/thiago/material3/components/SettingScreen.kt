package br.thiago.material3.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen() {

    var userName by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Your user name  is $userName")
        TextField(
            value = userName,
            label = {
                Text(text = "Enter your name")
            },
            placeholder = {
                Text(text = "User name")
            },
            onValueChange = { newValue ->
                userName = newValue
            },
            isError = userName.isEmpty(),
        )
        Spacer(modifier = Modifier.height(30.dp))
        var composeSelected by remember { mutableStateOf(false) }
        var xmlSelected by remember { mutableStateOf(false) }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                selected = composeSelected,
                onClick = {
                    composeSelected = !composeSelected
                },
                label = {
                    Text(text = "Compose")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = composeSelected) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)

                    }

                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            FilterChip(
                selected = xmlSelected,
                onClick = {
                    xmlSelected = !xmlSelected
                },
                label = {
                    Text(text = "XML")
                },
                leadingIcon = {
                   AnimatedVisibility(visible = xmlSelected ) {
                       Icon(imageVector = Icons.Default.Done, contentDescription = null)
                       
                   }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        var composeSkills by remember { mutableStateOf(1f) }

        Text(text = "Compose Skills:${composeSkills.toInt()}")
        Slider(
            value = composeSkills,
            onValueChange = {newValue ->
                composeSkills = newValue
            },
            steps = 4,
            valueRange = 1f..5f
        )

        Spacer(modifier = Modifier.height(30.dp))

        var darkModeEnabled by remember {
            mutableStateOf(false)
        }
        Text(text = "Dark mode is ${if (darkModeEnabled) "enabled" else "disabled"}")
        Switch(
            thumbContent = {
                           AnimatedVisibility(visible = darkModeEnabled) {
                               Icon(imageVector = Icons.Filled.DarkMode, contentDescription = null)

                           }

            },
            checked = darkModeEnabled,
            onCheckedChange = {newValue ->
            darkModeEnabled = newValue


        })
        
    }


}
