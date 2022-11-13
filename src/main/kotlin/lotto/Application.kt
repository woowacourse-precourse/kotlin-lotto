package lotto

import domain.CreateLottoNumber
import view.InputView
import view.OutputView

fun main() {

    // 티켓 구매
    val inputView = InputView()
    val availableTickets = inputView.inputMoney()

    val outputView = OutputView()
    outputView.outputAvailableTickets(availableTickets)

    val createLottoNumber = CreateLottoNumber()
    createLottoNumber.createRandomLottoNumber()

    //val lotto = Lotto(list)

}
