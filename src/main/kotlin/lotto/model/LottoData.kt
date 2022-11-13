package lotto.model

import lotto.util.Constants.DEFAULT_NUMBER
import lotto.util.LottoResult.THREE_COINCIDE
import lotto.util.LottoResult.FOUR_COINCIDE
import lotto.util.LottoResult.FIVE_COINCIDE
import lotto.util.LottoResult.FIVE_AND_BONUS_COINCIDE
import lotto.util.LottoResult.SIX_COINCIDE

object LottoData {
    var publishedLottoNumber: Int = DEFAULT_NUMBER
    var winningNumbers: List<Int> = emptyList()
    var lottos: ArrayList<List<Int>> = arrayListOf()
    var lottosLotto: ArrayList<Lotto> = arrayListOf()
    var bonusNumber: Int = DEFAULT_NUMBER
    var lottoStats = mutableMapOf(
        THREE_COINCIDE to 0,
        FOUR_COINCIDE to 0,
        FIVE_COINCIDE to 0,
        FIVE_AND_BONUS_COINCIDE to 0,
        SIX_COINCIDE to 0
    )
}
