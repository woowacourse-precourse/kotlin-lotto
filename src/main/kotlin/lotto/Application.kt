package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    val lottoGame = LottoGame()
    lottoGame.receiveMoney(Console.readLine())
    println(lottoGame.printLottoCount().toString()+"개를 구매했습니다.")

    lottoGame.printLotto()



}
