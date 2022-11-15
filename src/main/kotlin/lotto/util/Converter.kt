package lotto.util

fun String.toListSplitByComma(): List<String> {
    return this.split(",")
}