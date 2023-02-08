package com.sgut.android.nationalfootballleague.commoncomposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeadingSection(modifier: Modifier = Modifier, title: String, subtitle: String, content: @Composable ()-> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = title, style = MaterialTheme.typography.h6.copy(fontSize = 14.sp))
        Text(text = subtitle, style = MaterialTheme.typography.subtitle2)
        Divider()
        content()
    }
}