package lotto.utils.validation

class UniquenessVerifier(private val numbers: List<Int>) : Verifier<Int>() {
    override fun verify(input: Int) {
        require(!numbers.contains(input)) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not an unique number."
    }
}