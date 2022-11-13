package lotto.util

import lotto.model.LottoData
import lotto.model.LottoData.lottosLotto
import lotto.model.LottoData.publishedLottoNumber
import lotto.util.Constants.FIVE_AND_BONUS_COINCIDE_WINNING_PRIZE_NUMBER
import lotto.util.Constants.FIVE_COINCIDE_WINNING_PRIZE_NUMBER
import lotto.util.Constants.FOUR_COINCIDE_WINNING_PRIZE_NUMBER
import lotto.util.Constants.LOTTO_UNIT_NUMBER
import lotto.util.Constants.SIX_COINCIDE_WINNING_PRIZE_NUMBER
import lotto.util.Constants.THREE_COINCIDE_WINNING_PRIZE_NUMBER

object Statistics {

    fun processStatistics() {
        lottosLotto.forEach {
            it.saveLottoData()
        }
    }

    fun getTotalRateOfReturn(): Double {
        var sum = 0
        sum += LottoData.lottoStats[LottoResult.THREE_COINCIDE]!! * THREE_COINCIDE_WINNING_PRIZE_NUMBER
        sum += LottoData.lottoStats[LottoResult.FOUR_COINCIDE]!! * FOUR_COINCIDE_WINNING_PRIZE_NUMBER
        sum += LottoData.lottoStats[LottoResult.FIVE_COINCIDE]!! * FIVE_COINCIDE_WINNING_PRIZE_NUMBER
        sum += LottoData.lottoStats[LottoResult.FIVE_AND_BONUS_COINCIDE]!! * FIVE_AND_BONUS_COINCIDE_WINNING_PRIZE_NUMBER
        sum += LottoData.lottoStats[LottoResult.SIX_COINCIDE]!! * SIX_COINCIDE_WINNING_PRIZE_NUMBER
        return (sum.toDouble() / (publishedLottoNumber * LOTTO_UNIT_NUMBER)) * 100
    }
}