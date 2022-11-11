package lotto.util

private const val MSG_PREFIX = "[ERROR]"

fun requireWithPrefix(value: Boolean, msg: String) {
    require(value) { "$MSG_PREFIX $msg" }
}
