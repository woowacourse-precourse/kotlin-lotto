package lotto.utils.validation

class IntegersVerifier : Verifier<List<String>>() {
    override fun verify(input: List<String>) {
        input.map { number -> requireNotNull(number.toIntOrNull()) { ERROR_MESSAGE } }
    }

    companion object {
        const val ERROR_MESSAGE = "Some of them are not integer."
    }
}