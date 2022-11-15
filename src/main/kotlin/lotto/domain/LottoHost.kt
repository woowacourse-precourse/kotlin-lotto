package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Message
import lotto.ui.GuideLotto

class LottoHost {
    private fun pickWinningNumber(): List<Int> {
        GuideLotto().printWinningNumber()
        val inputWinningNumber = Console.readLine()
        throwWinningNumber(inputWinningNumber)

        return inputWinningNumber.split(",").map { it.toInt() }.toList()
    }

    private fun pickBonusNumber(): Int {
        GuideLotto().printBonusNumber()
        val inputBonusNumber = Console.readLine().toInt()
        throwBonusNumber(inputBonusNumber)

        return inputBonusNumber
    }

    fun createWinningNumber(): MutableList<Int> {
        val winningNumber = mutableListOf<Int>()
        val pickWinningNumber = pickWinningNumber()
        val pickBonusNumber = pickBonusNumber()

        winningNumber.apply {
            addAll(pickWinningNumber)
            add(pickBonusNumber)
        }

        throwLottoException(pickWinningNumber, pickBonusNumber)

        return winningNumber
    }

    fun throwWinningNumber(inputWinningNumber: String) {
        if (!inputWinningNumber.contains(",")) throw IllegalArgumentException("양식을 지켜주세요. ex)1,2,3,4,5,6")
    }

    fun throwBonusNumber(inputBonusNumber: Int) {
        if (inputBonusNumber !in 1..45) throw IllegalArgumentException("보너스 번호는 1개의 숫자만 입력 가능합니다")
    }

    fun throwLottoException(
        winningNumber: List<Int>,
        bonusNumber: Int
    ) {

        if (winningNumber.size != 6) throw IllegalArgumentException("당첨 번호는 6개의 숫자만 입력 가능합니다")
        if (winningNumber.distinct().size != 6) throw IllegalArgumentException("중복된 숫자가 존재합니다")

        for (number in winningNumber.indices) {
            if (winningNumber[number] !in 1 until 46)
                throw IllegalArgumentException(Message.LOTTO_NUMBER_RULE.message)
        }

        if (winningNumber.contains(bonusNumber)) throw IllegalArgumentException("당첨번호와 보너스번호는 중복될 수 없습니다.")
    }
}