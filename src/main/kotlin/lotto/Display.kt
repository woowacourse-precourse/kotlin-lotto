package lotto

import utils.Constants
import utils.Constants.PURCHASE_COUNT_MESSAGE
import utils.Constants.REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE

class Display {

    fun printRequirePurchaseAmount() {
        println(REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLottoCount(count: Int) {
        println("${count}$PURCHASE_COUNT_MESSAGE")
    }
    fun printLottos(lottos: List<Lotto>) {
        for(lotto in lottos) {
            val numbers = lotto.getLotto()
            print("[")
            for(i in 0 until numbers.size - 1) {
                print("${numbers[i]}, ")
            }
            println("${numbers.last()}]")
        }
    }
}