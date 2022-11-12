package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    val lottoGame = LottoGame()
    lottoGame.receiveMoney(Console.readLine())
    println("${lottoGame.printLottoCount()}개를 구매했습니다.")

    lottoGame.printLotto()

    println("당첨 번호를 입력해 주세요.")
    lottoGame.receiveWinningNumber(Console.readLine())

    println("보너스 번호를 입력해 주세요.")
    lottoGame.receiveBonusNumber(Console.readLine())

    println("당첨 통계\n---")
    lottoGame.printResult()



}
