package br.thiago.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.thiago.material3.ui.theme.Material3Theme
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme {

                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                        }) {
                            Icon(imageVector = Icons.Outlined.Call, contentDescription = null)


                        }
                    },
                    topBar = {
                        Material3TopAppBar()
                    },
                    bottomBar = {
                        MaterialBottomBar()
                    }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                            .verticalScroll(
                                rememberScrollState()
                            )
                    ) {
                        Column {
                            MaterialDogCard()
                            MaterialDogCard()
                        }
                    }


                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialDogCard() {

    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        onClick = {
            expanded = !expanded
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = Modifier.padding(
            horizontal = 10.dp, vertical = 15.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {
            Column {
                val dogUrl =
                    "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"

                AsyncImage(
                    model = dogUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                )
                Text(
                    text = "This is my Dog",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                )
                val desc =
                    "O Pastor Alemão é um cão robusto, inteligente e leal, conhecido por sua versatilidade em trabalho e companhia. Com pelagem densa, geralmente preta e castanha, eles são excelentes guardiões e companheiros. Necessitam de exercício e estímulo mental diário. São propensos a displasia do quadril e outras condições de saúde. Ideais para famílias ativas e treináveis para diversas funções"
                Text(
                    text = desc,
                    fontSize = 15.sp,
                    maxLines = if(expanded) 20 else 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
fun MaterialBottomBar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.Create,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = null
                )
            }

        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3TopAppBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,

                    )
            }
        },
        actions = {

            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.Create,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = null
                )
            }
        },

        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = {
            Text(text = "Material App 3")
        })
}


