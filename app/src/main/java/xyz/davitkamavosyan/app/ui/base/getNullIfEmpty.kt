package xyz.davitkamavosyan.app.ui.base

fun String.getNullIfEmpty(): String? {
    return if (this.isEmpty() || this.isBlank()) {
        null
    } else {
        this
    }
}