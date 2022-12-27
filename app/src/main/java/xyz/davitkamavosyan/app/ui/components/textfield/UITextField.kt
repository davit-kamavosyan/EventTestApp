package xyz.davitkamavosyan.app.ui.components.textfield

import androidx.annotation.StringRes
import xyz.davitkamavosyan.app.R

data class UITextField(
    val value: String = "",
    val errorResId: Int = R.string.the_filed_is_required,
    @StringRes
    val titleResId: Int = R.string.empty_text,
    val placeHolderResId: Int = R.string.empty_text,
    val isError: Boolean = false,
    val required: Boolean = false,
    val maxLeathers: Int = 100,
    val enabled: Boolean = true,
    val includeErrorBoxSize: Boolean = false
) {
    fun isDataRequiredButNotDefined(): Boolean {
        return if (required) {
            value.isEmpty() || value.isBlank()
        } else {
            false
        }
    }
}