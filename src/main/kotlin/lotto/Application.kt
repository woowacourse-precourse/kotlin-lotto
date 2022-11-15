package lotto

import domain.*
import view.InputView
import view.OutputView


fun main() {

    // 입력 뷰
    val inputView = InputView()
    // 출력 뷰
    val outputView = OutputView()

    // 구입할 금액 메시지 출력
    outputView.outputHowMuchBuy()

    // 구입할 금액 입력
    val money = inputView.inputMoney()
    outputView.outputMoney(money)
    outputView.newLine()

    // 구매 가능한 티켓 출력
    val availableTickets = CalculateNumberOfTickets().calculateNumberOfTickets(money)
    outputView.outputAvailableTickets(availableTickets)

    // 로또 생성
    val lottoNumberRepository = LottoNumberRepository()
    val listOfLotto = lottoNumberRepository.lottoNumberRepository(availableTickets)

    // 로또 숫자 출력
    outputView.outputListOfLotto(listOfLotto)
    outputView.newLine()

    // 당첨 번호 메시지 출력
    outputView.outputWinningNumber()

    // 담청 번호 입력
    val winningNumber = inputView.inputWinningNumber()
    outputView.newLine()

    // 보너스 번호 메시지 출력
    outputView.outputBonusNumber()

    // 보너스 번호 입력
    val bonusNumber = inputView.inputBonusNumber(winningNumber)
    println(bonusNumber)
    outputView.newLine()

    // 당첨 통계 메세지
    outputView.outputWinningStatistics()

    // 당첨 통계 출력
    val winningLotto = WinningStatistics().winningStatistics(listOfLotto, winningNumber, bonusNumber)
    val winningMap = WinningStatistics().winningMap(winningLotto)
    outputView.outputWinningStatisticsResult(winningMap)

    // 총 수익률 출력
    val income = WinningStatistics().incomeCalculation(winningLotto)
    outputView.outputTotalYield(money, income)
}
