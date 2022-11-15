package lotto.utils.validation

class RangesVerifier(private val min: Int, private val max: Int) : Verifier<List<Int>>() {
    override fun verify(input: List<Int>) {
        input.map { number -> require(number in min..max) { "$ERROR_MESSAGE $min and $max" } }
    }

    companion object {
        const val ERROR_MESSAGE = "Some elements are not between"
    }
}