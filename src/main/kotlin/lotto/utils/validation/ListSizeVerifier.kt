package lotto.utils.validation

class ListSizeVerifier(private val size: Int) : Verifier<List<Int>>() {
    override fun verify(input: List<Int>) {
        require(input.size == size) { "$ERROR_MESSAGE $size." }
    }

    companion object {
        const val ERROR_MESSAGE = "The number of elements is not"
    }
}