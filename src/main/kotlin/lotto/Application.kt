package lotto
import camp.nextstep.edu.missionutils.Console

fun main() {
    try{
        launch()
    } catch (e: IllegalArgumentException) {
        print(e.message)
    }
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
            throw IllegalArgumentException(ErrorStrings.INVALID_PURCHASE_AMOUNT_ENTERED.message + ErrorStrings.INVALID_PURCHASE_AMOUNT_UNITS.message)
        return amount

    } catch (_: NumberFormatException) {
        throw IllegalArgumentException(ErrorStrings.INVALID_PURCHASE_AMOUNT_ENTERED.message)
    }
}

fun lottoNumbers(string: String): List<Int> {
    val result: Set<Int>
    try {
        result = string.split(",").map {
            validateNumberRange(it.toInt())
            it.toInt()
        }.toSet()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException(ErrorStrings.INVALID_WINNING_NUMBER_ENTERED.message)
    }

    return result.toList()
}

fun bonusNumber(string: String): Int {
    return try {
        validateNumberRange(string.toInt())
        string.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException(ErrorStrings.INVALID_BONUS_NUMBER_ENTERED.message)
    }
}

fun validateNumberRange(number: Int) {
    if (number < 1 || number > 45) {
        throw IllegalArgumentException(ErrorStrings.INVALID_BONUS_NUMBER_ENTERED.message)
    }
}




