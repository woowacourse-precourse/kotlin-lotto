package lotto.domain

interface Generator {
    fun generateNumbers(): List<Int>
}