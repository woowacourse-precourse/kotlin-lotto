package lotto

class InputValidator<T>(private val validators: List<Verifier<T>>) {
    fun validate(input: T) {
        validators.map { validator -> validator.verify(input) }
    }
}