package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.NormalDivider
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader


@Composable
fun ArticleCard(
    articleModel: ArticleDomianModel,
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
            .background(Color.White)
            .fillMaxSize()) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                if (articleModel.images.isNotEmpty()) {
                    GenericImageLoader(
                        obj = articleModel.images.first().url,
                        modifier = modifier.width(200.dp).padding(bottom = 6.dp)
                    )
                }

                NormalDivider()

                Text(
                    text = articleModel.headline,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                )
            }
        }
    }
}

// if list is needed
@Composable
fun ArticleList(articleList: List<ArticleDomianModel>, modifier: Modifier) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
            ArticleCard(articleModel = article, modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
fun ArticleRow(articleList: List<ArticleDomianModel>) {
    LazyRow(contentPadding = PaddingValues(8.dp)) {
        items(items = articleList) { article ->
            ArticleCard(articleModel = article, modifier = Modifier)
        }
    }
}

@Composable
fun HeadLine(modifier: Modifier) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Box(modifier = modifier.width(350.dp)) {
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



