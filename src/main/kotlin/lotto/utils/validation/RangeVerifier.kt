package lotto.utils.validation

class RangeVerifier(private val min: Int, private val max: Int) : Verifier<Int>() {
    override fun verify(input: Int) {}
}