package xyz.davitkamavosyan.app.ui.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.components.text.TextToolbar
import xyz.davitkamavosyan.app.ui.components.text.TextToolbarAction
import xyz.davitkamavosyan.app.ui.theme.AppTheme


@Composable
fun UIToolbar(
    @DrawableRes navigationIconResId: Int?,
    onNavigationIconClicked: () -> Unit,
    title: String,
    actionText: String,
    actionButtonEnabled: Boolean = true,
    onActionIconClicked: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(color = AppTheme.colors.uiToolbarColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        navigationIconResId?.let {
            TextButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 2.dp)
                    .padding(start = 8.dp),
                onClick = onNavigationIconClicked,
                shape = CircleShape
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = rememberVectorPainter(image = ImageVector.vectorResource(id = navigationIconResId)),
                    contentDescription = "",
                    tint = AppTheme.colors.toolbarIconColor
                )
            }
        }
        TextToolbar(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            text = title
        )
        TextButton(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            shape = CircleShape,
            onClick = onActionIconClicked,
            enabled = actionButtonEnabled
        ) {
            TextToolbarAction(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = actionText,
                enabled = actionButtonEnabled
            )
        }
    }
}

@Preview
@Composable
private fun UiToolbarPreview() {
    UIToolbar(navigationIconResId = R.drawable.ic_baseline_close_24,
        onNavigationIconClicked = {},
        title = "title",
        actionText = "action",
        onActionIconClicked = {})
}