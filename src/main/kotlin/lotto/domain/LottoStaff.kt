package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoStaff() {

    fun countLotto(amount: Int): Int {
        return amount / LOTTO_PRICE
    }

    fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers.sorted())
    }

    fun countMatchingNumber(lottoNumbers: List<Int>, winningNumbers: List<Int>): Int {
        var count = 0
        lottoNumbers.forEach { number ->
            if (winningNumbers.contains(number)) count++
        }
        return count
    }

    fun checkBonusNumber(lottoNumbers: List<Int>,bonusNUmber:Int):Boolean{
        return lottoNumbers.contains(bonusNUmber)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}