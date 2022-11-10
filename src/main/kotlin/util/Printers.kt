package util

import lotto.domain.Lotto

object Printers {

    // 로또 구매할 금액 문구 출력
    fun userInputMoney() {
        println(Messages.USER_INPUT_MESSAGE)
    }

    // 구매한 로또들 출력
    fun lottoList(list: List<Lotto>) {
        nextLine()
        println("${list.size}" + Messages.AMOUNT_LOTTO_MESSAGE)
        list.forEach { lotto ->
            println(lotto.getOrderedNumbers())
        }
        nextLine()
    }

    private fun nextLine() {
        println()
    }
}