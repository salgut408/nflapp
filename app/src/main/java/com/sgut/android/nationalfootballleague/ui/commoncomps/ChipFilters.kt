package com.sgut.android.nationalfootballleague.ui.commoncomps

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.domain.domainmodels.Filter





@Composable
fun FilterTitle(text: String) {
    Text(text = text, style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(bottom = 8.dp))
}


@Composable
fun FilterBar(
    filters: List<Filter>,
    onShowFilters: () -> Unit,
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 12.dp, 8.dp),
        modifier = Modifier.heightIn(min = 56.dp)
    ) {
        item { 
            IconButton(onClick = onShowFilters) {
                Icon(
                   imageVector = Icons.Filled.Menu,
                    contentDescription = "",

                )
                
            }
        }
        items(filters) {filter ->
            FilterChip(filter = filter, shape = MaterialTheme.shapes.small)
        } 
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChip(
    filter: Filter,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
) {
    val (selected, setSelected) = filter.enabled
    val backGroundColor by animateColorAsState(
        if (selected) Color.Red else Color.Yellow
    )

        val interactionSource = remember { MutableInteractionSource() }
        val pressed by interactionSource.collectIsPressedAsState()
        val backgroundPressed = if (pressed) Color.Blue else Color.Transparent

        AssistChip(
            onClick = { },
            modifier = modifier,
            interactionSource = interactionSource,
            shape = shape,
            enabled = selected,
            label = { Text(text = filter.displayName) },

        )


}