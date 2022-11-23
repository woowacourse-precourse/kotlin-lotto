package lotto.domain

import lotto.enums.Rating
import kotlin.math.round

class LottoService {

    fun isWinningLotto(lottoNumbers: MutableList<Lotto>, winningNumbers: Lotto, bonusNumber: Int): MutableList<Rating> {
        val ranks: MutableList<Rating> = mutableListOf()
        for (lottoNumber in lottoNumbers) {
            val (hit, bonus) = compareNumbers(lottoNumber, winningNumbers, bonusNumber)
            ranks.add(getRank(hit to bonus))
        }
        return ranks
    }

    fun compareNumbers(lottoNumber: Lotto, winningNumbers: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        var (hit, bonus) = lottoNumber.compare(winningNumbers, bonusNumber)
        return isBonusNecessary(hit, bonus)
    }

    fun isBonusNecessary(hit: Int, bonus: Boolean): Pair<Int, Boolean> {
        if ((hit != HIT_FIVE) and bonus) {
            return hit to false
        }
        return hit to bonus
    }

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

    fun countRank(resultOfLotto: MutableList<Rating>, rating: Rating): Int {
        return resultOfLotto.count { it == rating }
    }

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