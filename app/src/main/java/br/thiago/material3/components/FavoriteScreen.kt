package br.thiago.material3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun FavoriteScreen() {
    val image1 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image2 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image3 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image4 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image5 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image6 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    val image7 =
        "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"

    var dogList = remember {
        mutableStateListOf(
            Dog(name = "German Shepherd", image = image1),
            Dog(name = "German Shepherd", image = image2),
            Dog(name = "German Shepherd", image = image3),
            Dog(name = "German Shepherd", image = image4),
            Dog(name = "German Shepherd", image = image5),
            Dog(name = "German Shepherd", image = image6),
            Dog(name = "German Shepherd", image = image7),

            )
    }

    LazyVerticalGrid(modifier = Modifier.size(800.dp), columns = GridCells.Fixed(2), content = {
        itemsIndexed(dogList) { index, dog ->
            Card(modifier = Modifier.size(200.dp)) {
                Box(modifier = Modifier.fillMaxSize()) {
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier
                            .zIndex(1f)
                            .align(Alignment.TopEnd),
                        onClick = {
                            // dogList.removeAt(index)
                            //dogList.add(index, dog.copy(isFavorite = !dog.isFavorite))
                            dogList[index] = dog.copy(isFavorite = !dog.isFavorite)

                        }) {

                        Icon(
                            imageVector = if (dog.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )

                    }
                    AsyncImage(
                        model = dog.image,
                        contentDescription = "dog image",
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface.copy(alpha =0.5f )
                            )


                    ){
                        Text(
                            text = dog.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .zIndex(1f)
                                .padding(8.dp)
                                .align(Alignment.CenterStart)
                        )
                    }
                }
            }
        }
    })
//    LazyColumn(modifier = Modifier.size(800.dp)) {
//        items(dogList) { dog ->
//            Card(modifier = Modifier.size(200.dp)) {
//                Box(modifier = Modifier.fillMaxSize()) {
//                    AsyncImage(
//                        model = dog.image,
//                        contentDescription = "dog image",
//                        contentScale = ContentScale.Crop
//                    )
//                }
//            }
//        }
//    }
}

data class Dog(
    val name: String,
    val image: String,
    val isFavorite: Boolean = false


)