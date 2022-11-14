package lotto

import camp.nextstep.edu.missionutils.Randoms

/*
* Return: unique한 1~45 사이의 6자리를 담은 리스트의 Lotto
* Do: Lotto 생성자 생성
* */
fun generateLotto(): Lotto {
    return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
}


fun main() {
    // 1. 사용자 입력 받기
    // 로또 구입 금액 입력
    // 1000원 = 1장
    println("구매금액을 입력해 주세요.")
    val userPayMoney = readLine()!!.toInt()
    val userAmountTobuy = userPayMoney / 1000

    // 로또 당첨 번호 입력
    println("\n당첨 번호를 입력해 주세요.")
    val winLottoNumberString = readLine()!!.toString()
    val winLottoNumber = winLottoNumberString.split(",").map { it.toInt() }


    // 보너스 번호 입력
    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = readLine()!!.toInt()
}
