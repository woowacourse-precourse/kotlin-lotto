package lotto.utils.validation

class PositiveNumberVerifier : Verifier<Int>() {
    override fun verify(input: Int) {
        require(input > 0) {
            println("$ERROR_HEADER $ERROR_MESSAGE")
            ERROR_MESSAGE
        }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not a positive number."
    }
}