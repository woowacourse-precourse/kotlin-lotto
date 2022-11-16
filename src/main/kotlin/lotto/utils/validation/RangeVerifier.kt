package lotto.utils.validation

class RangeVerifier(private val min: Int, private val max: Int) : Verifier<Int>() {
    override fun verify(input: Int) {
        require(input in min..max) { "$ERROR_MESSAGE $min and $max." }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not between"
    }
}