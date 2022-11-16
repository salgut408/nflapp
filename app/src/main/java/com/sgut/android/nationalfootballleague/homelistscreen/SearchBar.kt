package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.ui.theme.md_theme_dark_background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SearchBar(
    modifier: Modifier = Modifier,

) {
    var searchString by remember {mutableStateOf("")}
    TextField (
        value = searchString,
        onValueChange = {searchString = it},
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
            .clickable { }
    )
}








