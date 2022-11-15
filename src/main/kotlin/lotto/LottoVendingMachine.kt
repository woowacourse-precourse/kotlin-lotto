package lotto

import util.InputException
import util.Printer
import util.Printer.Companion.FIRST_PRIZE
import util.Printer.Companion.FIVTH_PRIZE
import util.Printer.Companion.FOURTH_PRIZE
import util.Printer.Companion.SECOND_PRIZE
import util.Printer.Companion.THIRD_PRIZE

class LottoVendingMachine(
    private val user: User,
    private val machine: Machine,
    private val printer: Printer,
    private val inputException: InputException
) {
    fun execution() {
        purchaseLotto()
        issueLotto()
        val winnings = inputWinningNumbers()
        val totalPrize = calculatePrize(winnings)
        outputLottoResult(totalPrize, winnings)
    }

    private fun inputWinningNumbers(): List<Int> {
        val numbers = inputLottoNumbers()
        val bonus = inputBonusNumber(numbers)
        return Lotto(numbers).lottoCalculate(machine.lottos, bonus)
    }

    private fun outputLottoResult(totalPrize: Int, winnings: List<Int>) {
        printer.apply {
            printLottoResultMessage()
            printLottoResultTable(winnings)
        }
        val rate = machine.winningsRate(user.inputMoney, totalPrize)
        printer.printReturnRate(rate)
    }

    private fun calculatePrize(winnings: List<Int>): Int {
        val prizes = listOf(FIVTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)
        return winnings.mapIndexed { idx, count -> count * prizes[idx] }.sum()
    }

    private fun purchaseLotto() {
        printer.printPurchaseMessage()
        user.inputMoney()
    }

    private fun issueLotto() {
        val lottoCount = user.getLottos()
        printer.printCountLotto(lottoCount)
        printer.printLottoIssue(machine.issueLottos(), lottoCount)
    }

    private fun inputLottoNumbers(): List<Int> {
        printer.printInputLottoMessage()
        return user.inputNumbers()
    }

    private fun inputBonusNumber(numbers: List<Int>): Int {
        printer.printInputBonusMessage()
        val bonus = user.inputBonus()
        if (numbers.contains(bonus)) inputException.checkBonusException(numbers, bonus)
        return bonus
    }

}
