package lotto.presentation

import lotto.domain.LottoCheck
import lotto.domain.LottoShop
import lotto.domain.LottoWin
import lotto.presentation.util.inputMoneyException
import lotto.presentation.util.inputTypeException
import java.lang.IllegalArgumentException

class LottoGame {

    fun gameStart(){
        try {
            val userOrder = inputUserLotto()
            val userLottoNumber = LottoShop().buyLotto(userOrder)
            val userInputWinNum = LottoWin().winLotto(inputWinLotto())
            LottoWin().bonusLotto(userInputWinNum, inputBonusLotto())
            val lottoRank = LottoCheck().compareLotto(userLottoNumber)
            LottoBank().yieldLotto(lottoRank, userOrder)

        }catch (e: IllegalArgumentException){
            println("[ERROR] 잘못입력하셨습니다.")
        }
    }

    fun inputUserLotto(): Int {
        println("구입금액을 입력해 주세요.")
        val buyAmount = readLine()!!
        buyAmount.inputTypeException()
        return buyAmount.inputMoneyException()

    }

    fun inputWinLotto(): List<String> {
        println("\n당첨 번호를 입력해 주세요.")
        return readLine()!!.split(',')
    }

    fun inputBonusLotto(): String {
        println("\n보너스 번호를 입력해 주세요.")
        return readLine()!!
    }

}