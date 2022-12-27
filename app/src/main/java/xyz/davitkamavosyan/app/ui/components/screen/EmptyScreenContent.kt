package io.settlo.inventories.ui.components.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.settlo.inventories.ui.components.button.UIOutlineButton
import io.settlo.inventories.ui.components.icon.UIIcon
import xyz.davitkamavosyan.app.ui.components.text.TextBody2
import xyz.davitkamavosyan.app.ui.components.text.TextOutlineButton
import xyz.davitkamavosyan.app.ui.components.text.TextTitle2
import xyz.davitkamavosyan.app.ui.theme.AppTheme


@Composable
fun EmptyScreenContent(
    @DrawableRes iconResId: Int,
    title: String,
    description: String,
    buttonText: String,
    @DrawableRes buttonIconResId: Int?,
    onClick: (() -> Unit) ?
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        UIIcon(iconResId = iconResId)
        TextTitle2(
            text = title,
            modifier = Modifier.padding(top = 24.dp),
            textAlign = TextAlign.Center
        )
        TextBody2(
            text = description,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        if(onClick != null){
            UIOutlineButton(onClick = onClick, modifier = Modifier.padding(top = 24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    buttonIconResId?.let {
                        Icon(
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(12.dp),
                            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = buttonIconResId)),
                            contentDescription = buttonText,
                            tint = AppTheme.colors.outlineButtonIconColor
                        )
                    }
                    TextOutlineButton(text = buttonText)
                }
            }
        }
    }
}

@Preview
@Composable
private fun EmptyScreenContentPreview() {
//    EmptyScreenContent(
//        iconResId = R.drawable.ic_empty_inventories,
//        title = "title",
//        description = "description ".repeat(20),
//        buttonText = "", buttonIconResId = R.drawable.ic_button_add,
//        onClick = {}
//    )
}