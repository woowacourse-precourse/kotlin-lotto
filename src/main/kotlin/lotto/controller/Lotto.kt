package lotto.controller

import lotto.model.Strings

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.toSet().size == 6) { Strings.Input_Six_WinningNum.reward }
    }


    fun countSameLotto(winningNumbers: List<Int>, lottoNumbers: List<Int>): Int {
        var count = 0

        for (i in 0 until winningNumbers.size) {
            if (lottoNumbers.contains(winningNumbers[i])) {
                count++
            }

        }
        return count
    }

    fun countSameWithBonus(lottoNumbers: List<Int>, bonusNum: Int): Boolean {

        return lottoNumbers.contains(bonusNum)
    }

}
