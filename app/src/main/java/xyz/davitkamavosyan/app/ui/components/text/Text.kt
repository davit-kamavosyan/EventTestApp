package xyz.davitkamavosyan.app.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import xyz.davitkamavosyan.app.ui.theme.AppTheme

@Composable
fun TextTitle1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.title1
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextTitle2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.title2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextTitle3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.title3
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextSubtitle1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.subtitle1
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextSubtitle2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.subtitle2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextSubtitle3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.titleTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.subtitle3
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextButton1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.buttonTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button1
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextError(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.errorColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.subtitle2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextOutlineButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.outlineButtonTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextButton2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.buttonTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.button2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextHint1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textFiledHintColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.hint1
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextHint2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textFiledHintColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.hint2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextBody1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textBodyColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body1
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextBody2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textBodyColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body2
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextBody3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textBodyColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body3
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextBody4(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textBodyColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.body4
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextToolbar(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.toolbarTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.toolbar
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextToolbarAction(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = if (enabled) {
        AppTheme.colors.toolbarTextColor
    } else {
        AppTheme.colors.toolbarTextColorDisabled
    },
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.toolbarAction,
) {
    Text(
        text = text.uppercase(),
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextAction(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = if (enabled) {
        AppTheme.colors.toolbarTextColor
    } else {
        AppTheme.colors.toolbarTextColorDisabled
    },
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.toolbarAction,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}


@Composable
fun TextNavigationRail(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.toolbarTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.toolbarAction
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}

@Composable
fun TextAction(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.toolbarTextColor,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTheme.typography.toolbarAction
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}