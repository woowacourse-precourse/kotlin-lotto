package lotto.utils.validation

class DistinctVerifier : Verifier<List<Int>>() {
    override fun verify(input: List<Int>) {
        require(input.distinct().size == input.size) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "There are some duplicate numbers."
    }
}