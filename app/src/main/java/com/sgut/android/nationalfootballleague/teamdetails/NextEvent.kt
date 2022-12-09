package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.NextEvent3

@Composable
fun NextEvent(
    nextEvent3: NextEvent3,
    modifier: Modifier
) {
    Card (
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier

            ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.fillMaxWidth()
        ) {



            Text(text = "Next Event:",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )

            Text(text = nextEvent3.name)
            Text(text = nextEvent3.competitions[0].venue.fullName)
            Text(text = nextEvent3.date)
        }


    }
}

