package xyz.davitkamavosyan.app.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val background: Color,
    val titleTextColor: Color,
    val buttonTextColor: Color,
    val outlineButtonTextColor: Color,
    val outlineButtonIconColor: Color,
    val buttonColor: Color,
    val textFiledActiveColor: Color,
    val textFiledColor: Color,
    val textFiledBorderColor: Color,
    val textFiledHintColor: Color,
    val textFiledBackgroundColorDisabled: Color,
    val navigationRailBackgroundColor: Color,
    val textNavigationRailBackgroundColor: Color,
    val dashboardToolbarColor: Color,
    val uiToolbarColor: Color,
    val lineColor: Color,
    val iconBoxColor: Color,
    val iconColor: Color,
    val iconSelectedColor: Color,
    val textBodyColor: Color,
    val toolbarTextColor: Color,
    val toolbarTextColorDisabled: Color,
    val toolbarIconColor: Color,
    val textNavigationRailNormalColor: Color,
    val textNavigationRailSelectedColor: Color,
    val textNavigationRailSelectedBackgroundColor: Color,
    val cardColor: Color,
    val stepInternetRequiredBoxColor: Color,
    val infoIconColor: Color,
    val errorColor: Color,
    val colorPrimary: Color,
    val colorWhite: Color,
    val negativeButtonColor: Color,
    val overviewIconColor: Color,
    val overviewIconBackgroundColor: Color,
    val borderColor: Color,

    )

val LocalCustomColors = staticCompositionLocalOf {
    AppColors(
        background = Color(0xFFF8FAFB),
        titleTextColor = Color(0xFF242732),
        buttonTextColor = Color(0xFFFFFFFF),
        outlineButtonTextColor = Color(0xFF0F2C7A),
        textFiledActiveColor = Color(0xFF0F2C7A),
        buttonColor = Color(0xFF0F2C7A),
        textFiledColor = Color(0xFF242732),
        textFiledHintColor = Color(0xFF959DB3),
        textFiledBorderColor = Color(0xFFEEEFF9),
        navigationRailBackgroundColor = Color(0xFFF8FAFB),
        textNavigationRailBackgroundColor = Color(0xFFFFFFFF),
        dashboardToolbarColor = Color(0xFFFFFFFF),
        uiToolbarColor = Color(0xFFF8FAFB),
        lineColor = Color(0xFFECEEF4),
        iconBoxColor = Color(0xFFF8FAFB),
        textBodyColor = Color(0xFF747C96),
        outlineButtonIconColor = Color(0xFF0F2C7A),
        toolbarTextColor = Color(0xFF0F2C7A),
        toolbarIconColor = Color(0xFF0F2C7A),
        textNavigationRailNormalColor = Color(0xFF747C96),
        textNavigationRailSelectedColor = Color(0xFF0F2C7A),
        textNavigationRailSelectedBackgroundColor = Color(0xFFF8FAFB),
        cardColor = Color(0xFFFFFFFF),
        iconColor = Color(0xFFA5AEC7),
        iconSelectedColor = Color(0xFF4DB24B),
        stepInternetRequiredBoxColor = Color(0xFFFFFAE0),
        infoIconColor = Color(0xFFF9B700),
        errorColor = Color(0xFFB00020),
        colorPrimary = Color(0xFF0F2C7A),
        textFiledBackgroundColorDisabled = Color(0xFFEEEFF9),
        colorWhite = Color(0xFFFFFFFF),
        toolbarTextColorDisabled = Color(0xFF9BA8C7),
        negativeButtonColor = Color(0xFFE94849),
        overviewIconColor = Color(0xFF5E6784),
        overviewIconBackgroundColor = Color(0xFFF8FAFB),
        borderColor = Color(0xFFDFE1E9)
    )
}

fun Color.toHexCode(): String {
    val red = this.red * 255
    val green = this.green * 255
    val blue = this.blue * 255
    return String.format("#%02x%02x%02x", red.toInt(), green.toInt(), blue.toInt())
}

