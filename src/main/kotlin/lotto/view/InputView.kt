package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants.INPUT_PURCHASING_AMOUNT

object InputView {

    fun inputPurchasingAmount(): Long {
        println(INPUT_PURCHASING_AMOUNT)
        return Console.readLine().toLong()
    }
}
