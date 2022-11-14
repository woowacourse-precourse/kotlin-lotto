package lotto

import domain.CreateLottoNumber
import domain.LottoNumberRepository
import view.InputView
import view.OutputView

fun main() {

    // 입력 뷰
    val inputView = InputView()
    // 출력 뷰
    val outputView = OutputView()

    // 구매 티켓 개수
    val availableTickets = inputView.inputMoney()

    // 구매 가능한 티켓 출력
    outputView.outputAvailableTickets(availableTickets)

    // 로또 숫자 출력
    outputView.outputListOfLotto(availableTickets)

    // 담청 번호 입력
    val winningNumber = inputView.inputWinningNumber()

    // 보너스 번호 입력
    val bonusNumber = inputView.inputBonusNumber()

    //val lotto = Lotto(list)

}
