package lotto

object Error {
    const val errorHeader = "[ERROR]"
    fun showError(errorType: ErrorType) {
        finishWithError(errorType)
    }

    private fun finishWithError(errorType: ErrorType) {
        PrintForm().printError(errorType)
        throw IllegalArgumentException()
    }
}