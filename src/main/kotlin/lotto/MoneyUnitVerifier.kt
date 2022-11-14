package lotto

class MoneyUnitVerifier(private val divisor: Int) : Verifier<Int>() {
    override fun verify(input: Int) {
        require(input % divisor == 0) {
            println("$ERROR_HEADER $ERROR_MESSAGE")
            ERROR_MESSAGE
        }
    }

    companion object {
        const val ERROR_MESSAGE = "Input is not divisible by the divisor."
    }
}