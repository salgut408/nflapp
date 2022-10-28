package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.ui.theme.md_theme_dark_background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SeachBar(
    modifier: Modifier = Modifier
) {
 TextField (
     value = "",
     onValueChange = {},
     leadingIcon = {
         Icon(
             imageVector = Icons.Default.Search,
             contentDescription = null
         )
     },
   placeholder = {
       Text("Search")
   },
     modifier = modifier
         .fillMaxWidth()
         .heightIn(min = 56.dp)
         )
}