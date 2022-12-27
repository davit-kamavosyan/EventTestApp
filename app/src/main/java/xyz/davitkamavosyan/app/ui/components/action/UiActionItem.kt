package xyz.davitkamavosyan.app.ui.components.action


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.components.text.TextSubtitle2
import xyz.davitkamavosyan.app.ui.theme.AppTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UiActionItem(
    modifier: Modifier = Modifier, onEditClick: () -> Unit = {}, onDeleteClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(modifier = modifier, expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }) {
        TextButton(
            onClick = {

            }, modifier = Modifier.size(48.dp), shape = CircleShape
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                contentDescription = "",
                tint = AppTheme.colors.colorPrimary
            )
        }

        ExposedDropdownMenu(modifier = Modifier.width(150.dp),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onEditClick()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_edit_24),
                    contentDescription = "",
                    tint = AppTheme.colors.colorPrimary
                )
                TextSubtitle2(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "Edit",
                    color = AppTheme.colors.colorPrimary

                )
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClick()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_delete_24),
                    contentDescription = "",
                    tint = AppTheme.colors.negativeButtonColor
                )
                TextSubtitle2(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "Delete",
                    color = AppTheme.colors.negativeButtonColor
                )
            }
        }
    }
}