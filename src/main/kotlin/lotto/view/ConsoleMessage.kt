package lotto.view

import lotto.domain.Lotto

class ConsoleMessage {
    enum class Message(val sentence: String) {
        INPUT_MESSAGE("구입금액을 입력해 주세요."),
        VERIFY_NUMBER("개를 구매했습니다."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("당첨 통계\n---"),
        SAME_THREE_NUMBER("3개 일치 (5,000원) - "),
        SAME_FOUR_NUMBER("4개 일치 (50,000원) - "),
        SAME_FIVE_NUMBER("5개 일치 (1,500,000원) - "),
        SAME_FIVE_NUMBER_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SAME_SIX_NUMBER("6개 일치 (2,000,000,000원) - "),
        TOTAL_REVENUE("총 수익률은 "),
        AMOUNT("개"), DESCRIBE_TOTAL_REVENUE("입니다.")
    }

    fun inputPurchaseAmount() {
        println(Message.INPUT_MESSAGE.sentence)
    }

    fun verifyNumber(number: Int) {
        println("${number}${Message.VERIFY_NUMBER.sentence}")
    }

    fun outputComputerNumber(computerNumber: List<Lotto>) {
        for (numberLine in computerNumber) {
            println(numberLine.getNumbers())
        }
    }

    fun inputWinningNumber() {
        println(Message.WINNING_NUMBER.sentence)
    }

    fun inputBonusNumber() {
        println(Message.BONUS_NUMBER.sentence)
    }

    fun winningResult(prizeResult: ArrayList<Int>) {
        println(Message.WINNING_STATISTICS.sentence)
        println("${Message.SAME_THREE_NUMBER.sentence}${prizeResult[0]}${Message.AMOUNT.sentence}")
        println("${Message.SAME_FOUR_NUMBER.sentence}${prizeResult[1]}${Message.AMOUNT.sentence}")
        println("${Message.SAME_FIVE_NUMBER.sentence}${prizeResult[2]}${Message.AMOUNT.sentence}")
        println("${Message.SAME_FIVE_NUMBER_AND_BONUS_NUMBER.sentence}${prizeResult[3]}${Message.AMOUNT.sentence}")
        println("${Message.SAME_SIX_NUMBER.sentence}${prizeResult[4]}${Message.AMOUNT.sentence}")
    }

    fun winningTotalRevenue(revenue: String) {
        println("${Message.TOTAL_REVENUE.sentence}${revenue}${Message.DESCRIBE_TOTAL_REVENUE.sentence}")
    }

    fun printError(message: String) {
        println(message)
    }
}