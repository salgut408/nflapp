package com.sgut.android.nationalfootballleague.homelistscreen

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

@Composable
fun TeamCard(team: TeamDomainModel, modifier: Modifier) {


    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .clickable {  }
           ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
//             image
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.logos?.get(0)?.href)
                    .crossfade(true)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = team.displayName,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
            team.displayName?.let { Text(text = it,   style = MaterialTheme.typography.displaySmall, )  }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            team.nickname?.let { Text(text = it,   style = MaterialTheme.typography.titleSmall, )  }

        }
    }
    
}
































