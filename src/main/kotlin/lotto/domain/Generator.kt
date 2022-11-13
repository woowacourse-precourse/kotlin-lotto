package lotto.domain

interface Generator {
    fun generateNumbers(n: Int): List<Int>
}