package io.settlo.inventories.ui.components.line

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.davitkamavosyan.app.ui.theme.AppTheme


@Composable
fun VerticalLine(modifier: Modifier) {
    Spacer(modifier = modifier
        .width(1.dp)
        .background(color = AppTheme.colors.lineColor))
}

@Composable
fun HorizontalLine(modifier: Modifier) {
    Spacer(modifier = modifier
        .height(1.dp)
        .background(color = AppTheme.colors.lineColor))
}