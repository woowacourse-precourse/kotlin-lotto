package lotto

import lotto.domain.User

class LottoGame {
    val user = User()

    fun gameStart() {
        val userGameAmount = user.inputUserAmount()
    }
}