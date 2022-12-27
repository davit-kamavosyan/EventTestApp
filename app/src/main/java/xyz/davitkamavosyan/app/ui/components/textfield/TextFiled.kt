package xyz.davitkamavosyan.app.ui.components.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import xyz.davitkamavosyan.app.ui.components.text.TextError
import xyz.davitkamavosyan.app.ui.components.text.TextHint2
import xyz.davitkamavosyan.app.ui.components.text.TextSubtitle2
import xyz.davitkamavosyan.app.ui.theme.AppTheme


@Composable
fun UITextFieldItem(
    item: UITextField,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    includeErrorBoxSize: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.OutlinedTextFieldShape,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = AppTheme.colors.textFiledActiveColor,
        cursorColor = AppTheme.colors.textFiledActiveColor,
        unfocusedBorderColor = AppTheme.colors.textFiledBorderColor
    ),
    textFieldHeightDp: Int? = null,
    onClick: (() -> Unit)? = null
) {
    Column(modifier) {

        Row() {
            TextSubtitle2(
                modifier = Modifier, text = stringResource(id = item.titleResId)
            )
            if (item.required) {
                Text(
                    text = " *", color = AppTheme.colors.errorColor
                )
            }
        }

        val isPressed: Boolean by interactionSource.collectIsPressedAsState()

        if (onClick != null) {
            if (isPressed) {
                onClick()
            }
        }

        OutlinedTextField(
            value = item.value,
            onValueChange = {
                if (it.length <= item.maxLeathers) {
                    onValueChange(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .then(
                    if (textFieldHeightDp != null) {
                        Modifier.height(textFieldHeightDp.dp)
                    } else {
                        Modifier
                    }
                ),
            enabled = item.enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            label = label,
            placeholder = {
                TextHint2(text = stringResource(id = item.placeHolderResId))
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = item.isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors
        )

        if (includeErrorBoxSize) {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .padding(top = 4.dp, bottom = 12.dp)
            ) {
                if (item.isError) {
                    TextError(
                        text = stringResource(id = item.errorResId), maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        } else {
            if (item.isError) {
                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .padding(top = 4.dp, bottom = 12.dp)
                ) {
                    TextError(
                        text = stringResource(id = item.errorResId), maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


@Composable
fun UiClickableTextFieldItem(
    item: UITextField,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    includeErrorBoxSize: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.OutlinedTextFieldShape,
    isRequired: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = AppTheme.colors.textFiledActiveColor,
        cursorColor = AppTheme.colors.textFiledActiveColor,
        unfocusedBorderColor = AppTheme.colors.textFiledBorderColor,
        backgroundColor = if (item.enabled) {
            Color.Transparent
        } else {
            AppTheme.colors.textFiledBackgroundColorDisabled
        }
    )
) {

    val isPressed: Boolean by interactionSource.collectIsPressedAsState()

    Column(modifier) {

        Row() {
            TextSubtitle2(
                modifier = Modifier, text = stringResource(id = item.titleResId)
            )
            if (isRequired) {
                Text(
                    text = " *", color = AppTheme.colors.errorColor
                )
            }
        }

        if (isPressed) {
            onClick()
        }

        OutlinedTextField(
            value = item.value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clickable(interactionSource = interactionSource, indication = null, onClick = {
                    onClick()
                }),
            enabled = item.enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            label = label,
            placeholder = {
                TextHint2(text = stringResource(id = item.placeHolderResId))
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors
        )
        if (includeErrorBoxSize) {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .padding(top = 4.dp, bottom = 12.dp)
            ) {
                if (isError) {
                    TextError(
                        text = stringResource(id = item.errorResId), maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        } else {
            if (isError) {
                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .padding(top = 4.dp, bottom = 12.dp)
                ) {
                    TextError(
                        text = stringResource(id = item.errorResId), maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
