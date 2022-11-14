package lotto

abstract class Verifier<T> {
    abstract fun verify(input: T)

    companion object {
        const val ERROR_HEADER = "[ERROR]"
    }
}