package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    launch()
}

fun launch() {
    println("구입금액을 입력해 주세요.")
    val purchaseAmount = purchase(Console.readLine())
    val automaticLotteryTickets = AutomaticLotteryTickets(purchaseAmount)
    println()

    println("${automaticLotteryTickets.countTickets()}개를 구매했습니다.")
    for(ticket in automaticLotteryTickets) {
        println(ticket)
    }
    println()

    println("당첨 번호를 입력해 주세요.")
    val lottoNum = lottoNumbers(Console.readLine())
    val lotto = Lotto(lottoNum)
    println()

    println("보너스 번호를 입력해 주세요.")
    val bonusNum = bonusNumber(Console.readLine())
    println()

    // 당첨 통계를 위한 LottoWinningStat 객체 생성
    val lottoWinningStat = LottoWinningStat(lotto, bonusNum, automaticLotteryTickets)
    println("당첨 통계")
    println("---")
    println(lottoWinningStat.toString())
}

fun purchase(string: String): Int {
    try {
        val amount: Int = string.toInt()
        if (amount % 1000 != 0)
            throw throwPurchaseInputException()
        return amount

    } catch (_: NumberFormatException) {
        throw throwPurchaseInputException()
    }
}

fun lottoNumbers(string: String): List<Int> {
    var result: Set<Int> = setOf()
    try {
        result = string.split(",").map {
            validateNumberRange(it.toInt())
            it.toInt()
        }.toSet()
    } catch (_: NumberFormatException) {
        throwWinningNumberInputException()
    }

    return result.toList()
}

fun bonusNumber(string: String): Int {
    return try {
        validateNumberRange(string.toInt())
        string.toInt()
    } catch (_: NumberFormatException) {
        println("[ERROR] 보너스 번호가 올바르게 입력되지 않음")
        throw IllegalArgumentException()
    }
}

fun validateNumberRange(number: Int) {
    if (number < 1 || number > 45) {
        throwWinningNumberInputException()
    }
}

fun throwWinningNumberInputException() {
    println("[ERROR] 당첨 번호 입력이 올바르지 않음")
    throw IllegalArgumentException()
}

fun throwPurchaseInputException(): IllegalArgumentException {
    println("[ERROR] 구입 금액 입력이 올바르지 않음")
    return IllegalArgumentException()
}




