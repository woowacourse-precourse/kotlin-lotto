package lotto

import camp.nextstep.edu.missionutils.Randoms

/*
* Return: unique한 1~45 사이의 6자리를 담은 리스트의 Lotto
* Do: Lotto 생성자 생성
* */
fun generateLotto(): Lotto {
    return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
}

/*
* Parameters: userAmountTobuy
* Return: Lotto 생성자를 담은 리스트
* Do: 사용자가 입력한 금액만큼 로또를 담을 리스트 생성
* */
fun buyLotto(userAmountTobuy: Int): List<Lotto> {
    println("\n"+"$userAmountTobuy"+"개를 구매했습니다.")

    // 전체 로또번호를 담을 리스트
    var lottoList: MutableList<Lotto> = mutableListOf()

    // 리스트에 갯수만큼 로또를 생성하여 담아준다
    for ( i in 0..userAmountTobuy - 1 ) {
        lottoList.add(generateLotto())
    }

    return lottoList
}


fun main() {
    // 1. 사용자 입력 받기
    // 로또 구입 금액 입력
    // 1000원 = 1장
    println("구매금액을 입력해 주세요.")
    val userPayMoney = readLine()!!.toInt()
    val userAmountTobuy = userPayMoney / 1000
    val lottoList = buyLotto(userAmountTobuy)

    // 구입한 로또 리스트 출력
    lottoList.forEach{it.printLotto()}

    // 로또 당첨 번호 입력
    println("\n당첨 번호를 입력해 주세요.")
    val winLottoNumberString = readLine()!!.toString()
    val winLottoNumber = winLottoNumberString.split(",").map { it.toInt() }


    // 보너스 번호 입력
    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = readLine()!!.toInt()
}
