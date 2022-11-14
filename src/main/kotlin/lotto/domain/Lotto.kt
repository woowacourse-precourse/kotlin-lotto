package lotto.domain

import java.util.Collections.sort

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == numbers.size)
        sort(numbers)
    }

    fun numbers() = numbers

}
