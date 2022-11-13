package lotto.view

import lotto.domain.Lotto

fun printNumberOfTickets(ticket: Int) {
    println("${ticket}개를 구매했습니다.")
}

fun printNumbersOfLottos(lottos: List<Lotto>) {
    lottos.forEach {
        println(it.toList())
    }
}

fun printWinningNumbers(winningNumbers: List<Int>) {
    println(winningNumbers.joinToString(","))
}

fun printBonusNumber(bonus: Int) {
    println(bonus)
}

fun printPrizeResult(rankResult: List<Int>) {
    println("당첨 통계\n---")
    println("3개 일치 (5,000원) - ${rankResult[4]}개")
    println("4개 일치 (50,000원) - ${rankResult[3]}개")
    println("5개 일치 (1,500,000원) - ${rankResult[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankResult[1]}개")
    println("6개 일치 (2,000,000,000원) - ${rankResult[0]}개")
}

fun printRateOfReturn(rateOfReturn: Float) {
    println("총 수익률은 ${rateOfReturn}%입니다.")
}
