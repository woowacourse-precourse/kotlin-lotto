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

    fun generateLotteries(lottoCount: Int): List<Lotto> {
        val lotteries = mutableListOf<Lotto>()
        for (i in 0 until lottoCount) {
            lotteries.add(generateLotto())
        }
        return lotteries
    }

    fun countMatchingNumber(lottoNumbers: List<Int>, winningNumbers: List<Int>): Int {
        var count = 0
        lottoNumbers.forEach { number ->
            if (winningNumbers.contains(number)) count++
        }
        return count
    }

    fun checkBonusNumber(lottoNumbers: List<Int>, bonusNUmber: Int): Boolean {
        return lottoNumbers.contains(bonusNUmber)
    }

    fun checkPrize(matchingNumber: Int, isBonusNumberMatch: Boolean):Prize {
        if (matchingNumber == 6) return Prize.FIRST
        if (matchingNumber == 5 && isBonusNumberMatch) return Prize.SECOND
        if (matchingNumber == 5 && !isBonusNumberMatch) return Prize.THIRD
        if (matchingNumber == 4) return Prize.FOURTH
        if (matchingNumber == 3) return Prize.FIFTH
        return Prize.NOTHING
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}