package lotto

abstract class Verifier<T> {
    abstract fun verify(input: T)
}