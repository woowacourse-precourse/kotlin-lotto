package lotto

import lotto.domain.LottoPurchase
import lotto.domain.User

class LottoGame {
    val user = User()


    fun gameStart() {
        val userGameAmount = user.inputUserAmount()
        val purchase = LottoPurchase(userGameAmount).randomLottoPurchase()
        val userGamePrizeNumber = user.inputUserPrizeNumber()
    }
}