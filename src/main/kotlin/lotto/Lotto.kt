package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

    private var winningNumber = listOf<Int>()

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
        winningNumber = numbers
    }

    fun changeToElement(): List<Int> {
        return winningNumber.toList()
    }
}
