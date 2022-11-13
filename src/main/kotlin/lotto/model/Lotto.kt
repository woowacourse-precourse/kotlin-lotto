package lotto.model

import lotto.model.LottoData.bonusNumber
import lotto.model.LottoData.lottoStats
import lotto.model.LottoData.winningNumbers
import lotto.util.Constants.WINNING_NUMBER_COUNT
import lotto.util.LottoResult

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WINNING_NUMBER_COUNT)
    }

    fun saveLottoData() {
        var count = 0
        var isBonusCoincided = false
        numbers.forEach {
            if (winningNumbers.contains(it)) count++
            if (it == bonusNumber) isBonusCoincided = true
        }
        when (count) {
            3 -> lottoStats[LottoResult.THREE_COINCIDE] = lottoStats[LottoResult.THREE_COINCIDE]!! + 1
            4 -> lottoStats[LottoResult.FOUR_COINCIDE] = lottoStats[LottoResult.FOUR_COINCIDE]!! + 1
            5 -> {
                if (!isBonusCoincided) {
                    lottoStats[LottoResult.FIVE_COINCIDE] = lottoStats[LottoResult.FIVE_COINCIDE]!! + 1
                } else {
                    lottoStats[LottoResult.FIVE_AND_BONUS_COINCIDE] =
                        lottoStats[LottoResult.FIVE_AND_BONUS_COINCIDE]!! + 1
                }
            }

            6 -> lottoStats[LottoResult.SIX_COINCIDE] = lottoStats[LottoResult.SIX_COINCIDE]!! + 1
            else -> Unit
        }
    }


}
