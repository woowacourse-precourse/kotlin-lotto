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
