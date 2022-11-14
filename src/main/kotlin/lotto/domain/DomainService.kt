package lotto.domain

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
        return isNecessaryBonus(hit, bonus)
    }

    /**
     * 3등 미만은 보너스 정보가 필요 없으므로 bonus 값을 false로 고정하는 함수
     * */
    fun isNecessaryBonus(hit: Int, bonus: Boolean): Pair<Int, Boolean> {
        if ((hit < 5) and bonus) {
            return hit to false
        }
        return hit to bonus
    }

    /**
     * 당첨 번호와 일치하는 수, 보너스 번호 일치 여부에 맞춰 등수를 반환하는 함수
     * */
    fun getRank(hitAndBonus: Pair<Int, Boolean>): Rating {
        when (hitAndBonus) {
            6 to false -> return Rating.FIRST
            5 to true -> return Rating.SECOND
            5 to false -> return Rating.THIRD
            4 to false -> return Rating.FOURTH
            3 to false -> return Rating.FIFTH
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
}