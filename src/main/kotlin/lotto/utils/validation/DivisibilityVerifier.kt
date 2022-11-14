package lotto.utils.validation

class DivisibilityVerifier(private val divisor: Int) : Verifier<Int>() {
    override fun verify(input: Int) {
        require(input % divisor == 0) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not divisible by the divisor."
    }
}