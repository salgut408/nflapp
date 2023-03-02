package com.sgut.android.nationalfootballleague.homelistscreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.ArticleCardImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel


@Composable
fun ArticleCard(
    articleModel: ArticleModel,
    modifier: Modifier,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .height(200.dp)
            .padding(8.dp)
            .width(200.dp)
    ) {
        Box(modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                GenericImageLoader(obj = articleModel.images.getOrNull(0)?.url.toString(),
                    modifier = Modifier.width(200.dp))
                Text(
                    text = articleModel.headline,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            }
        }
    }
}

@Composable
fun ArticleList(articleList: List<ArticleModel>) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
            ArticleCard(articleModel = article, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ArticleRow(articleList: List<ArticleModel>) {
    LazyRow(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
            ArticleCard(articleModel = article, modifier = Modifier)
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



