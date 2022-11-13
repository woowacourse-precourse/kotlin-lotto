package lotto.LottoCheck

import lotto.lottoStore.LottoReward

fun checkWinaLotto(lottoNumber: MutableList<List<Int>>, bonusNumber: Int, winningNumber: String): MutableList<Int> {
    var count: Int
    var lottoWinningAll = mutableListOf(0, 0, 0, 0, 0)
    for (lottonum in lottoNumber) {
        count = containLottoNum(winningNumber, lottonum)
        count = containBonusNum(count, lottonum, bonusNumber)
        lottoWinningAll = good(count)
    }
    printresult(lottoWinningAll)
    return lottoWinningAll
}

fun containLottoNum(winningNumber: String, lottoNumber: List<Int>): Int {
    val winningNumbers = winningNumber.split(",")
    var checkWinningNumber = 0
    for (userLottoNumber in winningNumbers) {
        if (lottoNumber.contains(userLottoNumber.toInt())) {
            checkWinningNumber++
        }
    }
    return checkWinningNumber
}

fun containBonusNum(checkWinningNumber: Int, lottoNumber: List<Int>, bonus: Int): Int {
    var checkWinning = checkWinningNumber
    if (checkWinning == 5) {
        if (lottoNumber.contains(bonus)) {
            checkWinning += 2
        }
    }
    return checkWinningNumber
}

fun good(checkWinningNumber: Int): MutableList<Int> {
    val resultWinning = mutableListOf(0, 0, 0, 0, 0)
    when (checkWinningNumber) {
        3 -> resultWinning[0] += 1
        4 -> resultWinning[1] += 1
        5 -> resultWinning[2] += 1
        6 -> resultWinning[4] += 1
        7 -> resultWinning[3] += 1
    }
    return resultWinning
}
fun printresult(resultWinning:MutableList<Int>){
    println("3개 일치 (5,000원) -"+resultWinning[0]+"개")
    println("4개 일치 (50,000원) -"+resultWinning[1]+"개")
    println("5개 일치 (1,500,000원) -"+resultWinning[2]+"개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) -"+resultWinning[4]+"개")
    println("6개 일치 (2,000,000,000원) -"+resultWinning[3]+"개")
}
fun plusMoney(buyLottoMoney: String, checkWinningScore: MutableList<Int>): Double {
    val buyLottoMoney = buyLottoMoney.toInt() * 1000
    var getMoney = 0
    getMoney += checkWinningScore[0] * LottoReward.THREE.value
    getMoney += checkWinningScore[1] * LottoReward.FOUR.value
    getMoney += checkWinningScore[2] * LottoReward.FIVE.value
    getMoney += checkWinningScore[3] * LottoReward.FIVEBONUS.value
    getMoney += checkWinningScore[4] * LottoReward.SIX.value
    val yieldUser: Double = getMoney.toDouble() / buyLottoMoney.toDouble()
    println(yieldUser * 100)
    return yieldUser
}