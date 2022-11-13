package lotto

import domain.CreateLottoNumber
import domain.LottoNumberRepository
import view.InputView
import view.OutputView

fun main() {

    // 티켓 구매
    val inputView = InputView()
    val availableTickets = inputView.inputMoney()

    // 구매 가능한 티켓 출력
    val outputView = OutputView()
    outputView.outputAvailableTickets(availableTickets)

    // 로또 숫자 출력
    val lottoNumberRepository = LottoNumberRepository()
    println(
        lottoNumberRepository.lottoNumberRepository(availableTickets))


    //val lotto = Lotto(list)

}
