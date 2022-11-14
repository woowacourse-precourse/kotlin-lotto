package lotto.utils.validation

class UniquenessVerifier(private val numbers: List<Int>) : Verifier<Int>() {
    override fun verify(input: Int) {}
}