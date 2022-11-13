package lotto

import view.InputView

fun main() {

    // 티켓 구매
    val inputView = InputView()
    val availableTickets = inputView.inputMoney()
    println(availableTickets)

    //val lotto = Lotto(list)

}
