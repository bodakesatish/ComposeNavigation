package com.bodakesatish.composenavigation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bodakesatish.composenavigation.data.DemoDataProvider.DemoDataProvider.itemList
import com.bodakesatish.composenavigation.data.ItemModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController) {

    val primaryGrey = Color(0xFFD3D5D0)
    Column(
        modifier = Modifier
            .background(color = primaryGrey)
            .fillMaxWidth()
    ) {
        TopAppBar(title = {
            Text(
                "Navigation Demo",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(200.dp, 28.dp)
            )
        }, actions = {
            IconButton(onClick = {
                navController.navigate("searchPage")
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    modifier = Modifier.padding(end = 8.dp),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

        }, modifier = Modifier
            .fillMaxWidth()
        )
        LazyColumn {
            items(itemList) { food ->
                MainPageContent(foodItem = food, onVideoClick = {
                    navController.navigate("detailPage")
                })
            }
        }
    }
}

@Composable
fun MainPageContent(foodItem: ItemModel, onVideoClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onVideoClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = foodItem.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = foodItem.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = foodItem.subtitle,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}