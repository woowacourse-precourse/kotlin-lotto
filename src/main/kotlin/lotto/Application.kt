package lotto

import kotlin.math.round

private val userInput = UserInput()
private val lottoPrint = LottoPrint()

fun inputPayment(): Int {
    lottoPrint.printPaymentMessage()

    return userInput.inputUserPayment()
}

fun inputWinnerNumbers(): List<Int> {
    lottoPrint.printWinnerNumberMessage()

    val winnerNumber = userInput.inputWinnerNumber()

    Lotto(winnerNumber)

    return winnerNumber
}

fun inputBonusNumbers(): Int {
    lottoPrint.printBonusNumberMessage()

    return userInput.inputBonusNumber()
}

fun purchaseLottoCount(payment: Int): Int = payment / 1000

fun purchaseLottos(payment: Int): List<List<Int>> {
    val purchaseLottoCount = purchaseLottoCount(payment)
    val lottos = mutableListOf<List<Int>>()
    for(count in 0 until purchaseLottoCount) {
        lottos.add(LottoMaker().createLottoNumbers())
    }
    return lottos
}

fun compareUserLottos(userLottos: List<List<Int>>, winnerNumber: List<Int>, bonusNumber: Int): List<Int> {
    val lottoResult = MutableList<Int>(5) { 0 }
    userLottos.forEach {
        when(LottoCompare(winnerNumber, bonusNumber).compareLotto(it)) {
            LottoResult.SIX -> lottoResult[4]++
            LottoResult.FIVE_BONUS -> lottoResult[3]++
            LottoResult.FIVE -> lottoResult[2]++
            LottoResult.FOUR -> lottoResult[1]++
            LottoResult.THREE -> lottoResult[0]++
            else -> {}
        }
    }
    return lottoResult
}

fun setEarningsValue(lottoResult: List<Int>): Long {
    return (( lottoResult[0] * LottoResult.THREE.reward ) +
            ( lottoResult[1] * LottoResult.FOUR.reward ) +
            ( lottoResult[2] * LottoResult.FIVE.reward ) +
            ( lottoResult[3] * LottoResult.FIVE_BONUS.reward ) +
            ( lottoResult[4] * LottoResult.SIX.reward )).toLong()
}

fun setEarningsPercent(earningsValue: Long, payment: Int): Double {
    val tmpEarningsPercent = ( (earningsValue.toDouble() / payment.toDouble()) * 100.0 )
    return round(tmpEarningsPercent * 10)/ 10.0
}

fun main() {
    // Game Start
    val payment = inputPayment()

    //로또 구매
    val userLottos = purchaseLottos(payment)

    // 구매한 로또 출력
    lottoPrint.printPurchaseLottoInfo(userLottos)

    // 당첨 번호 로또
    val winnerNumber = inputWinnerNumbers()

    // 보너스 번호
    val bonusNumber = inputBonusNumbers()

    val lottoResult = compareUserLottos(userLottos, winnerNumber, bonusNumber)

    val earningsValue = setEarningsValue(lottoResult)

    val earningsPercent = setEarningsPercent(earningsValue, payment)

    // 로또 결과 출력
    lottoPrint.printLottosResult(lottoResult, earningsPercent)
}
