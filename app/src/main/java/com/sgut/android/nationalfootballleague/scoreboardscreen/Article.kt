package com.sgut.android.nationalfootballleague.homelistscreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.commoncomposables.ArticleCardImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.ArticleModel


@Composable
fun ArticleCard(articleModel: ArticleModel, modifier: Modifier) {
    Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.width(180.dp).padding(4.dp).height(190.dp)) {
        Box() {
            Column(modifier = Modifier.fillMaxWidth()) {

                ArticleCardImageLoader(articleModel)


                    Text(
                        text = articleModel.headline,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Left,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

            }
        }
    }

}

@Composable
fun ArticleList(articleList: List<ArticleModel>, ) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
                ArticleCard(articleModel = article, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ArticleRow(articleList: List<ArticleModel>, ) {
    LazyRow(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
            ArticleCard(articleModel = article, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun HeadLine() {
    Card(shape = RoundedCornerShape(10.dp)) {
        Box(modifier = Modifier.width(350.dp)) {
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(Icons.Default.MoreVert, contentDescription = null)

                    Text(
                        text = "Sports world reacts to an amazing event in history. Griener Released",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Left,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

}



