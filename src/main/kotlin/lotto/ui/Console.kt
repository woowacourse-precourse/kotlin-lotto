package lotto.ui

import lotto.data.Lotto
import lotto.data.WinningTable
import lotto.error.ErrorMessages
import lotto.util.println
import lotto.util.roundAt
import java.text.DecimalFormat
import camp.nextstep.edu.missionutils.Console as ConsoleUtil

private typealias ConsoleError = ErrorMessages.ConsoleEnum

object Console {

    private val decimal = DecimalFormat("#,###")

    fun requestPurchaseAmount(): Int {
        println(Message.InputPurchaseAmount)
        return readLine().replace(",", "").toIntOrThrow()
    }

    fun requestWinningNumbers(): List<Int> {
        println(Message.InputWinningNumbers)
        return readLine().split(',').map { it.trim().toIntOrThrow() }
    }

    fun requestBonusNumber(): Int {
        println(Message.InputBonusNumber)
        return readLine().toIntOrThrow()
    }

    fun print(lotteries: List<Lotto>) {
        println(Message.ShowLotto, decimal.format(lotteries.size))
        println(lotteries.joinToString("\n") + "\n")
    }

    fun print(table: WinningTable) {
        val messages = Message.ShowWinningStatistics.messages

        println(messages[0])
        println(messages[1])
        println(table.records.joinToString("\n"))
        println(messages[2], table.returnOfRate.roundAt(-2).toBigDecimal())
    }

    private fun String.toIntOrThrow(): Int {
        return requireNotNull(toIntOrNull()) { ConsoleError.NotValidInteger }
    }

    private fun readLine(): String {
        val input = ConsoleUtil.readLine()
        println("$input\n")
        return input
    }

    enum class Message(vararg args: String) {

        InputPurchaseAmount("구입금액을 입력해 주세요."),
        InputWinningNumbers("당첨 번호를 입력해 주세요."),
        InputBonusNumber("보너스 번호를 입력해 주세요."),

        ShowLotto("%s개를 구매했습니다."),
        ShowWinningStatistics(
            "당첨 통계",
            "---",
            "총 수익률은 %s%%입니다.",
        );

        val messages: List<String> = args.toList()

        override fun toString(): String = messages.joinToString("\n")
    }
}