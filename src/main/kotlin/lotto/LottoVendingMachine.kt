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
        resultLottoWinnings(numbers, bonus)
    }

    private fun resultLottoWinnings(numbers: List<Int>, bonus: Int): List<Int> {
        val lotto = Lotto(numbers)
        val lottoResult = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0)
        machine.lottos.forEach { it ->
            val count = lotto.winningsCount(it)
            if (lotto.isBonusTrue(bonus)) {
                lottoResult[count + 1]++
                return@forEach
            }
            lottoResult[count]++
        }
        return lottoResult
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

    private fun inputBonusNumber(numbers: List<Int>): Int {
        printer.printInputBonusMessage()
        val bonus = user.inputBonus()
        if (numbers.contains(bonus)) inputException.checkOverlapException()
        return bonus
    }
}
