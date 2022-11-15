package lotto

import camp.nextstep.edu.missionutils.Console

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {


    fun inputWinLottoNumber() {
        val userInput = Console.readLine()
    }


    fun inputBonusLottoNumber(): Int {
        val userInput = Console.readLine()
        if (bonusLottoNumberInputIsValid(userInput)) {
            throw IllegalArgumentException()
        }

        return userInput.toInt()
    }

    private fun bonusLottoNumberInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) {
            return false
        }

        if (userInput.toInt() in LottoProcessConstValue.LOTTO_NUMBER_RANGE_START..LottoProcessConstValue.LOTTO_NUMBER_RANGE_END) {
            return false
        }

        return true
    }


    fun printInputLottoWinNumber() {
        println(LottoProcessConstValue.INPUT_LOTTO_WIN_NUMBER)
    }

    fun printInputLottoBonusNumber() {
        println(LottoProcessConstValue.INPUT_LOTTO_BONUS_NUMBER)
    }

}