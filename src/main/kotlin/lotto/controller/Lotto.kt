package lotto.controller

import lotto.model.Price

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.toSet().size == 6) { "[ERROR] 로또는 서로 다른 6개의 숫자만 가능합니다" }
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

    fun countSameWithBonus(lottoNumbers: List<Int>, bonusNum : Int) : Boolean{

        return lottoNumbers.contains(bonusNum)
    }





}
