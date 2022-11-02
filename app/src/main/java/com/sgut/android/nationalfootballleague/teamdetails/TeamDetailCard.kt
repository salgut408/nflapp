package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel

@Composable
fun TeamDetailCard(team: TeamDetailModel, modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .clickable {  }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            team.displayName?.let { Text(text = it,   style = MaterialTheme.typography.displaySmall, )  }
        }

    }

}