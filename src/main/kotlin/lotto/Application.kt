package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.lang.Math.abs
import java.math.RoundingMode
import java.text.DecimalFormat

/*
* Return: unique한 1~45 사이의 6자리를 담은 리스트의 Lotto
* Do: Lotto 생성자 생성
* */
fun generateLotto(): Lotto {
    return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
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

/*
* Parameters: 로또 리스트, 당첨 번호, 보너스 숫자
* Returns: 당첨 금액의 합계
* Do: 결과 출력
*   3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
* */

fun returnLottoResult(lottoList: List<Lotto>, winLottoNumber: List<Int>, bonusNumber: Int): Int {
    val winPlaceCount: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0)
    var totalWinningMoney = 0
    // 로또 리스트를 돌면서 각 로또의 당첨 결과 출력
    lottoList.forEach { lotto ->
        val result = lotto.generateResult(winLottoNumber, bonusNumber)
        println(result)
        if ( result == LottoWinningPlace.FIRST ){
            winPlaceCount[0] += 1
            totalWinningMoney += LottoWinningPlace.FIRST.winningMoney
        }
        if ( result == LottoWinningPlace.SECOND ){
            winPlaceCount[1] += 1
            totalWinningMoney += LottoWinningPlace.SECOND.winningMoney
        }
        if ( result == LottoWinningPlace.THIRD ){
            winPlaceCount[2] += 1
            totalWinningMoney += LottoWinningPlace.THIRD.winningMoney
        }
        if ( result == LottoWinningPlace.FOURTH ){
            winPlaceCount[3] += 1
            totalWinningMoney += LottoWinningPlace.FOURTH.winningMoney
        }
        if ( result == LottoWinningPlace.FIFTH ){
            winPlaceCount[4] += 1
            totalWinningMoney += LottoWinningPlace.FIFTH.winningMoney
        }
    }
    LottoWinningPlace.values().reversed().forEachIndexed{index, it ->
        if ( it.correctNum != 0 ) {
            print("${it.correctNum}개 일치")
            if ( it.isBonusNumCorrect ) print(", 보너스 볼 일치")
            print(" (${DecimalFormat("#,###").format(it.winningMoney)}원) ")
            println("- " + winPlaceCount.reversed()[index] + "개")
        }
    }

    return totalWinningMoney
}

/*
* Parameters:
* Return: None
* Do:
* */
fun calculateRevenue(userPayMoney: Double, totalWinningMoney: Double){
    var revenue = 0.0

    if ( totalWinningMoney != 0.0 ){
        revenue = ( totalWinningMoney / userPayMoney ) * 100
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.HALF_UP
        println("총 수익률은 ${df.format(revenue)}%입니다.")
    }else{
        println("총 수익률은 0.0%입니다.")
    }


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

    // 당첨 내역 출력
    val totalWinningMoney = returnLottoResult(lottoList, winLottoNumber, bonusNumber)

    // 수익률 계산
    calculateRevenue(userPayMoney.toDouble(), totalWinningMoney.toDouble())
}
