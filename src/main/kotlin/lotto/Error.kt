package lotto

object Error {
    private const val errorHeader = "[ERROR]"

    fun showError(errorType: ErrorType) {
        finishWithError(errorType)
    }

    private fun finishWithError(errorType: ErrorType) {
        throw IllegalArgumentException("$errorHeader ${EnumError().checkErrorType(errorType)}")
    }
}