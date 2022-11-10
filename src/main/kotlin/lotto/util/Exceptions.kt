package lotto.util

private const val MSG_PREFIX = "[ERROR]"

fun requireWithPrefix(value: Boolean, msg: String) {
    require(value) {
        val errorMsg = "$MSG_PREFIX $msg"
        println(errorMsg)
        errorMsg
    }
}
