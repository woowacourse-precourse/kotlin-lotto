package lotto.domain

import camp.nextstep.edu.missionutils.Console
import util.Exceptions
import util.Messages
import util.Printers

class LottoMachine(
    private val lotteries: List<Lotto>
) {

    private var winningNumber = mutableListOf<Int>()
    private var bonus = 0

    fun setWinningAndBonusNumber() {
        winningNumber = inputWinningNumber().toMutableList()
        bonus = inputBonusNumber()
    }
    private fun inputWinningNumber(): List<Int> {
        Printers.inputWinningNumber()
        val number = Console.readLine()
        val numberSplit = number.split(',')
        // 당첨번호 예외 확인
        Exceptions.run {
            val winningNumber = isValidWinningNumber(numberSplit)
            isValidRangeWinningNumber(winningNumber)
            require(winningNumber.size == 6) {
                throw IllegalArgumentException(Messages.ERROR_MESSAGE + Messages.ERROR_LOTTO_SIZE)
            }
            hasDuplicateNumbers(winningNumber)
        }
        Printers.nextLine()
        return numberSplit.map { it.toInt() }
    }

    private fun inputBonusNumber(): Int {
        Printers.inputBonusNumber()
        val bonus = Console.readLine()
        Exceptions.run {
            bonus.isValidBonusNumber()
            bonus.toInt().isValidRangeBonusNumber()
        }
        Printers.nextLine()
        return bonus.toInt()
    }

    // 구매한 로또 리스트 출력
    fun checkList() {
        Printers.lottoList(lotteries)
    }
}