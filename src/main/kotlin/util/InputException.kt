package util

class InputException {
    fun checkTypeException(input: String?) {
        try {
            input?.toInt()
        } catch (e: Exception) {
            invalidException(TYPE_EXCEPTION)
        }
    }

    fun invalidException(message: String) {
        throw IllegalArgumentException("[ERROR] : $message")
    }

    companion object {
        const val TYPE_EXCEPTION = "올바른 형식이 아닙니다."
    }
}