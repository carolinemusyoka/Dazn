package com.carolmusyoka.dazn.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IconButtonMenu(icon: ImageVector, onClick: () -> Unit= {}) {
    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.surface
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(44.dp)
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    title: String? = null,
    pressBack: () -> Unit = {},
    pressBookmark: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        IconButtonMenu(icon = Icons.Rounded.ArrowBackIosNew, onClick = pressBack)
        if (title != null) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
            )
        }
        IconButtonMenu(icon = Icons.Rounded.Favorite, onClick = pressBookmark)
    }
}

@Preview
@Composable
fun MenuPreview() {
    Menu(title = "Menu")
}