package lotto

import camp.nextstep.edu.missionutils.Console

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {


    fun inputWinLottoNumber() {
        val userInput = Console.readLine()
    }


    fun inputBonusLottoNumber(): Int {
        val userInput = Console.readLine()
        if (bonusLottoNumberInputIsValid(userInput)) {
            throw IllegalArgumentException(BONUS_NUMBER_PRICE_ERROR_MESSAGE)
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


    companion object {
        const val BONUS_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 보너스 점수는 1이상 45이하의 정수 값이어야 합니다."
    }

}