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

    // 당첨 번호 입력 출력
    fun inputWinningNumber() {
        println(Messages.WINNING_NUMBER_INPUT_MESSAGE)
    }

    // 보너스 번호 입력 출력
    fun inputBonusNumber() {
        println(Messages.BONUS_NUMBER_INPUT_MESSAGE)
    }

    fun nextLine() {
        println()
    }
}