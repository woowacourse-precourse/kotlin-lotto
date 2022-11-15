package lotto

import camp.nextstep.edu.missionutils.Console

class UserInput {
    private var _lottoWinnerNumber = mutableListOf<String>()
    fun inputUserPayment(): Int {
        var inputPayment = Console.readLine()
        inputPayment.forEach {
            if(!it.isDigit()) {
                println("[ERROR]")
                return 0
            }
        }
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