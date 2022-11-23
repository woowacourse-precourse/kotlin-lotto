package lotto.ui

import lotto.domain.LottoService
import lotto.domain.Lotto
import lotto.enums.LottoMessages
import lotto.enums.Rating

object View {
    private val lottoService = LottoService()

    fun showPurchasingAmount() {
        println(LottoMessages.INPUT_PURCHASING_AMOUNT)
    }

    fun showWinningNumber() {
        println(LottoMessages.INPUT_WINNING_NUMBERS)
    }

    fun showBonusNumber() {
        println(LottoMessages.INPUT_BONUS_NUMBER)
    }

    fun showCount(countOfLotto: Int) {
        println("${countOfLotto}개를 구매했습니다.")
    }

    /**
     * 구매한 로또 번호들을 출력하는 함수
     * */
    fun showPurchasedLotteries(lottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in lottoNumbers) {
            println(lottoNumber.toString())
        }
    }

    /**
     * 당첨 통계를 출력하는 함수
     * */
    fun showResult(resultOfLotto: MutableList<Rating>, countOfLotto: Int) {
        println(LottoMessages.STATS)
        println(LottoMessages.DIVIDER)
        println("${LottoMessages.HIT_THREE} - ${lottoService.countRank(resultOfLotto, Rating.FIFTH)}개")
        println("${LottoMessages.HIT_FOUR} - ${lottoService.countRank(resultOfLotto, Rating.FOURTH)}개")
        println("${LottoMessages.HIT_FIVE} - ${lottoService.countRank(resultOfLotto, Rating.THIRD)}개")
        println("${LottoMessages.HIT_FIVE_BONUS} - ${lottoService.countRank(resultOfLotto, Rating.SECOND)}개")
        println("${LottoMessages.HIT_SIX} - ${lottoService.countRank(resultOfLotto, Rating.FIRST)}개")
        println("${LottoMessages.TOTAL_INCOME_IS} ${lottoService.calculateIncome(resultOfLotto, countOfLotto)}%입니다.")
    }
}