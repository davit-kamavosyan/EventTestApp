package xyz.davitkamavosyan.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    settloTypography: AppTypography = LocalCustomTypography.current,
    settloColors: AppColors = LocalCustomColors.current,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCustomColors provides settloColors,
        LocalCustomTypography provides settloTypography,
        content = content
    )
}

object AppTheme {
    val colors:AppColors
        @Composable
        get() = LocalCustomColors.current
    val typography: AppTypography
        @Composable
        get() = LocalCustomTypography.current
}
