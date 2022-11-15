package lotto

import camp.nextstep.edu.missionutils.Console

class UserInput {
    private var _lottoWinnerNumber = mutableListOf<String>()
    fun inputUserPayment(): Int {
        val inputPayment = Console.readLine()
        PurchaseValueException(inputPayment)

        return inputPayment.toInt()
    }

    fun inputWinnerNumber(): List<Int> {
        val inputWinnerNumber = Console.readLine()
        LottoWinnerNumberException(inputWinnerNumber)

        _lottoWinnerNumber = LottoNumberSplit(inputWinnerNumber).getLottoNumbers().toMutableList()

        val tmpWinnerNumbers = LottoNumberSplit(inputWinnerNumber).getLottoNumbers()
        val winnerNumbers = mutableListOf<Int>()

        tmpWinnerNumbers.forEach {
            winnerNumbers.add(it.toInt())
        }

        return winnerNumbers
    }

    fun inputBonusNumber(): Int {
        val inputBonusNumber = Console.readLine()
        LottoBonusNumberException(inputBonusNumber, _lottoWinnerNumber)

        return inputBonusNumber.toInt()
    }
}