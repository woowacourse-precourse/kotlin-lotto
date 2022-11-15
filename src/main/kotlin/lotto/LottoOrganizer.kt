package lotto

import camp.nextstep.edu.missionutils.Console

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {

    fun inputWinLottoNumber() {
        val userInput = Console.readLine()
        if (!winLottoNumberInputIsValid(userInput)) {
            throw IllegalArgumentException(WIN_NUMBER_PRICE_ERROR_MESSAGE)
        }

    }

    private fun winLottoNumberInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) return false

        val userInputSplit = userInput.split(',')
        val validNumberCheck = IntArray(45)
        if (userInputSplit.size != 6) return false
        for (e in userInputSplit) {
            if(!isNumber(e)) return false
            if (!isValidLottoNumber(e.toInt(), validNumberCheck)) return false
        }
        return true
    }

    private fun isValidLottoNumber(number: Int, validNumberCheck: IntArray): Boolean {
        if (number < LottoProcessConstValue.LOTTO_NUMBER_RANGE_START || number > LottoProcessConstValue.LOTTO_NUMBER_RANGE_END) {
            return false
        }
        if (validNumberCheck[number] == 1) {
            return false
        }
        if (validNumberCheck[number] == 0) {
            validNumberCheck[number] = 1
        }
        return true
    }

    private fun isNumber(elementString: String): Boolean {
        return try {
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


    fun inputBonusLottoNumber(): Int {
        val userInput = Console.readLine()
        if (!bonusLottoNumberInputIsValid(userInput)) {
            throw IllegalArgumentException(BONUS_NUMBER_PRICE_ERROR_MESSAGE)
        }

        return userInput.toInt()
    }

    private fun bonusLottoNumberInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) {
            return false
        }

        if (userInput.toInt() < LottoProcessConstValue.LOTTO_NUMBER_RANGE_START || userInput.toInt() > LottoProcessConstValue.LOTTO_NUMBER_RANGE_END) {
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


    companion object {
        const val BONUS_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1이상 45이하의 정수 값이어야 합니다."
        const val WIN_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표를 기준으로 나누어, 6개의 1이상 45이하의 정수 값들이여야 합니다."
    }

}