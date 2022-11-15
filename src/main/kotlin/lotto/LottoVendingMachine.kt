package lotto

import util.InputException
import util.Printer

class LottoVendingMachine(
    private val user: User,
    private val machine: Machine,
    private val printer: Printer,
    private val inputException: InputException
) {
    fun execution() {
        purchaseLotto()
        issueLotto()
        val numbers = inputLottoNumbers()
        val bonus = inputBonusNumber(numbers)
        resultLottoWinnings(numbers,bonus)
    }

    private fun resultLottoWinnings(numbers: List<Int>, bonus: Unit) {

    }

    private fun purchaseLotto() {
        printer.printPurchaseMessage()
        user.inputMoney()
    }

    private fun issueLotto() {
        val lottoCount = user.getLottos()
        printer.printCountLotto(lottoCount)
        for (cnt in 1..lottoCount) {
            val lotto = machine.issueLottos()
            println(lotto)
        }
    }

    private fun inputLottoNumbers(): List<Int> {
        printer.printInputLottoMessage()
        return user.inputNumbers()
    }

    private fun inputBonusNumber(numbers: List<Int>) {
        printer.printInputBonusMessage()
        val bonus = user.inputBonus()
        if (numbers.contains(bonus)) inputException.checkOverlapException()
    }
}
