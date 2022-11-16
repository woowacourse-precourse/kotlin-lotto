package lotto.utils.validation

class PositiveNumberVerifier : Verifier<Int>() {
    override fun verify(input: Int) {
        require(input > 0) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not a positive number."
    }
}