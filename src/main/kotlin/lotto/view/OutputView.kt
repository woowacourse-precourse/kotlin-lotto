package lotto.view

import lotto.model.LottoData.lottoStats
import lotto.model.LottoData.lottos
import lotto.model.LottoData.publishedLottoNumber
import lotto.model.LottoPublisher
import lotto.util.Constants.LOTTO_RESULT_FIVE_AND_BONUS_COINCIDE
import lotto.util.Constants.LOTTO_RESULT_FIVE_COINCIDE
import lotto.util.Constants.LOTTO_RESULT_FOUR_COINCIDE
import lotto.util.Constants.LOTTO_RESULT_SIX_COINCIDE
import lotto.util.Constants.LOTTO_RESULT_THREE_COINCIDE
import lotto.util.Constants.TOTAL_PUBLISHED_LOTTO_NUMBER
import lotto.util.Constants.TOTAL_RATE_OF_RETURN
import lotto.util.Constants.WINNING_STATS
import lotto.util.LottoResult
import lotto.util.Statistics.getTotalRateOfReturn

class OutputView {

    lateinit var lottoPublisher: LottoPublisher

    fun printPublishedLotto() {
        println(TOTAL_PUBLISHED_LOTTO_NUMBER.format(publishedLottoNumber))
        lottoPublisher = LottoPublisher(publishedLottoNumber)
        lottos.forEach { lottoInfo ->
            println(lottoInfo)
        }
    }

    fun printWinningStats() {
        println(WINNING_STATS)
        println(LOTTO_RESULT_THREE_COINCIDE.format(lottoStats[LottoResult.THREE_COINCIDE]))
        println(LOTTO_RESULT_FOUR_COINCIDE.format(lottoStats[LottoResult.FOUR_COINCIDE]))
        println(LOTTO_RESULT_FIVE_COINCIDE.format(lottoStats[LottoResult.FIVE_COINCIDE]))
        println(LOTTO_RESULT_FIVE_AND_BONUS_COINCIDE.format(lottoStats[LottoResult.FIVE_AND_BONUS_COINCIDE]))
        println(LOTTO_RESULT_SIX_COINCIDE.format(lottoStats[LottoResult.SIX_COINCIDE]))
        println(TOTAL_RATE_OF_RETURN.format(getTotalRateOfReturn()))
    }

}