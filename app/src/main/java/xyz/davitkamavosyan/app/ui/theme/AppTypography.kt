package xyz.davitkamavosyan.app.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import xyz.davitkamavosyan.app.R

val InterSemiBold = FontFamily(Font(R.font.inter_semi_bold))
val InterMedium = FontFamily(Font(R.font.inter_medium))
val FontAwesome6DuotoneSolid900 = FontFamily(Font(R.font.font_awesome_6_duotone_solid_900))
val FontAwesome6ProSolid900 = FontFamily(Font(R.font.font_awesome_6_pro_solid_900))

@Immutable
data class AppTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val subtitle3: TextStyle,
    val button1: TextStyle,
    val button2: TextStyle,
    val hint1: TextStyle,
    val hint2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val toolbar: TextStyle,
    val toolbarAction: TextStyle,
    val navigationRail: TextStyle

)

val LocalCustomTypography = staticCompositionLocalOf {
    AppTypography(
        title1 = TextStyle(
            fontSize = 22.sp,
            lineHeight = 27.sp,
            fontFamily = InterSemiBold
        ),
        title2 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            fontFamily = InterSemiBold
        ),
        title3 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = InterSemiBold
        ),
        subtitle1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = InterMedium
        ),
        subtitle2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontFamily = InterMedium
        ),
        subtitle3 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 15.sp,
            fontFamily = InterMedium
        ),
        button1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = InterMedium
        ),
        button2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontFamily = InterMedium
        ),
        hint1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = InterMedium
        ),
        hint2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = InterMedium
        ),
        body1 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = InterMedium
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontFamily = InterMedium
        ),
        body3 = TextStyle(
            fontSize = 13.sp,
            lineHeight = 16.sp,
            fontFamily = InterMedium
        ),
        body4 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 17.sp,
            fontFamily = InterMedium
        ),
        toolbar = TextStyle(
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = InterMedium
        ),
        toolbarAction = TextStyle(
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontFamily = InterMedium
        ),
        navigationRail = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = InterMedium
        ),
    )
}