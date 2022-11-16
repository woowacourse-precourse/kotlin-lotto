package lotto

import lotto.domain.*

class LottoGame {
    val user = User()

    fun gameStart() {
        val userGameAmount = user.inputUserAmount()
        val purchase = LottoPurchase(userGameAmount).randomLottoPurchase().toList()
        val userGamePrizeNumber = user.inputUserPrizeNumber()
        val bonusNumber = user.inputUserBonusNumber(userGamePrizeNumber)
        val lottoWinner = LottoWin(purchase, userGamePrizeNumber, bonusNumber).findLottoWin().toList()
        val lottoProfitRate = LottoProfit(lottoWinner,userGameAmount)
    }
}