package lotto

import lotto.domain.LottoWin
import lotto.ui.LottoBuyer
import lotto.ui.LottoSeller
import java.lang.IllegalArgumentException

fun main() {
    try{
        var lottoWinningNumbers = arrayListOf<String>()
        val lottoMoney = LottoBuyer().inputLottoPurchasePrice()//구입 금액 입력
        val purchasedLotto = LottoSeller().calLottoCount(lottoMoney)//발행한 로또
        val lottoWinNumber = LottoSeller().inputPrizeNumber(lottoWinningNumbers)//당첨 번호
        val lottoBonus = LottoSeller().inputBonusNumber()//보너스 번호
        val lottoPrizeMoney = LottoWin().calPrize(purchasedLotto, lottoWinNumber, lottoBonus)
        LottoWin().printProfitRate(lottoMoney, lottoPrizeMoney)
    }catch (e: IllegalArgumentException){
        println("[ERROR] 잘못된 값을 입력하였습니다.")
    }
}