package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.CheckException

class Input {
    val inputPurchaseCentence = "구입금액을 입력해 주세요."


    fun inputPurchasemoney() {

        println(inputPurchaseCentence)
        var amount = Console.readLine()
        val check = CheckException(amount)
        println()
        println()

    }

    


}