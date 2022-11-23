package lotto.domain

import lotto.enums.Rating
import kotlin.math.round

class DomainService {
    /**
     * 당첨 여부 정보를 리턴하는 함수
     * */
    fun isWinningLotto(lottoNumbers: MutableList<Lotto>, winningNumbers: Lotto, bonusNumber: Int): MutableList<Rating> {
        val ranks: MutableList<Rating> = mutableListOf()
        for (lottoNumber in lottoNumbers) {
            val (hit, bonus) = compareNumbers(lottoNumber, winningNumbers, bonusNumber)
            ranks.add(getRank(hit to bonus))
        }
        return ranks
    }

    /**
     * 구입한 로또 번호와 당첨 번호를 비교하는 함수
     * */
    fun compareNumbers(lottoNumber: Lotto, winningNumbers: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        var hit = 0
        var bonus = false
        for (number in lottoNumber.getLottoNumbers()) {
            if (winningNumbers.getLottoNumbers().contains(number)) {
                hit += 1
            }
            if (number == bonusNumber) {
                bonus = true
            }
        }
        return isBonusNecessary(hit, bonus)
    }

    /**
     * 2등 이외에는 보너스 정보가 필요 없으므로 bonus 값을 false로 고정하는 함수
     * */
    fun isBonusNecessary(hit: Int, bonus: Boolean): Pair<Int, Boolean> {
        if ((hit != HIT_FIVE) and bonus) {
            return hit to false
        }
        return hit to bonus
    }

    /**
     * 당첨 번호와 일치하는 수, 보너스 번호 일치 여부에 맞춰 등수를 반환하는 함수
     * */
    fun getRank(hitAndBonus: Pair<Int, Boolean>): Rating {
        when (hitAndBonus) {
            HIT_SIX to false -> return Rating.FIRST
            HIT_FIVE to true -> return Rating.SECOND
            HIT_FIVE to false -> return Rating.THIRD
            HIT_FOUR to false -> return Rating.FOURTH
            HIT_THREE to false -> return Rating.FIFTH
        }
        return Rating.LOSE
    }

    /**
     * 당첨 통계 중 순위 당 갯수를 계산하는 함수
     * */
    fun countRank(resultOfLotto: MutableList<Rating>, rating: Rating): Int {
        return resultOfLotto.count { it == rating }
    }

    /**
     * 당첨 통계 중 수익률을 계산하는 함수
     * */
    fun calculateIncome(resultOfLotto: MutableList<Rating>, countOfLotto: Int): Double {
        var sum = 0.0
        for (rank in Rating.values()) {
            sum += countRank(resultOfLotto, rank) * rank.getPrize()
        }
        return round((sum / (countOfLotto * 1000) * 100) * 10) / 10
    }

    companion object {
        const val HIT_SIX = 6
        const val HIT_FIVE = 5
        const val HIT_FOUR = 4
        const val HIT_THREE = 3
    }
}