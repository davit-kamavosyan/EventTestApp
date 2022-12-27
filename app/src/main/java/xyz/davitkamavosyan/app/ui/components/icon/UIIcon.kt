package io.settlo.inventories.ui.components.icon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import xyz.davitkamavosyan.app.ui.theme.AppTheme
import xyz.davitkamavosyan.app.ui.theme.Shapes

@Composable
fun UIIcon(
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
    iconTint: Color = AppTheme.colors.iconColor,
    backgroundColor: Color = AppTheme.colors.iconBoxColor,
    contentDescription: String? = null,
    boxSize: Int = 56,
    iconSize: Int = 24
) {
    Box(
        modifier = modifier
            .size(boxSize.dp)
            .background(
                color = backgroundColor, shape = Shapes.medium
            ), contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(iconSize.dp),
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = iconTint
        )
    }
}


