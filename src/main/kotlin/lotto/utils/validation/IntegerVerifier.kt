package lotto.utils.validation

class IntegerVerifier : Verifier<String>() {
    override fun verify(input: String) {
        requireNotNull(input.toIntOrNull()) {
            println("$ERROR_HEADER $ERROR_MESSAGE")
            ERROR_MESSAGE
        }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not an integer."
    }
}