package com.sgut.android.nationalfootballleague.commoncomposables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// needs state hoisting
@Composable
fun DropDown(
    menuItems: List<String>,
    modifier: Modifier = Modifier
) {
    val selectedItem = remember { mutableStateOf("Select more Sports") }
    val isExpanded = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .clickable { isExpanded.value = true }
    ) {
        Text(selectedItem.value)
        Icon(Icons.Filled.ArrowDropDown, contentDescription = "")
        DropdownMenu(
            expanded = isExpanded.value,
            onDismissRequest = { isExpanded.value = false },
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
            ) {
            menuItems.forEachIndexed {index, name ->
                DropdownMenuItem(
                    text = {  name },
                    onClick = {
                        selectedItem.value = menuItems[index]
                        isExpanded.value = false
                    }
                )
            }

        }

    }

}