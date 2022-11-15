package lotto

import camp.nextstep.edu.missionutils.Console

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {

    private lateinit var winLottoNumber: List<Int>
    private var bonusLottoNumber = 0
    private var firstClassCount = 0
    private var secondClassCount = 0
    private var thirdClassCount = 0
    private var fourthClassCount = 0
    private var fifthClassCount = 0
    private var nothingClassCount = 0

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
            if (!isNumber(e)) return false
            if (!isValidLottoNumber(e.toInt(), validNumberCheck)) return false
        }
        winLottoNumber = userInputSplit.map { it.toInt() }
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
            elementString.toInt()
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
        bonusLottoNumber = userInput.toInt()
        return bonusLottoNumber
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

    fun produceLottoWinHistory() {
        for (proLottoNumber in producedLottoNumbers) {
            val matchCountPair = calculateLottoNumber(proLottoNumber)
            calculateTotalLotto(matchCountPair)
        }
        printTotalLottoResult()
    }

    private fun printTotalLottoResult(){
        println(LottoProcessConstValue.LOTTO_RESULT_FIFTH + fifthClassCount)
        println(LottoProcessConstValue.LOTTO_RESULT_FOURTH + fourthClassCount)
        println(LottoProcessConstValue.LOTTO_RESULT_THIRD + thirdClassCount)
        println(LottoProcessConstValue.LOTTO_RESULT_SECOND + secondClassCount)
        println(LottoProcessConstValue.LOTTO_RESULT_FIRST + firstClassCount)
    }


    private fun calculateLottoNumber(proLottoNumber: List<Int>): Pair<Int, Int> {
        var lottoNumberMatchCount = 0
        var bonusNumberMatchCount = 0
        for (n in proLottoNumber) {
            if (winLottoNumber.contains(n)) lottoNumberMatchCount += 1
            if (n == bonusLottoNumber) bonusNumberMatchCount += 1
        }

        return Pair(lottoNumberMatchCount, bonusNumberMatchCount)
    }

    private fun calculateTotalLotto(matchCountPair: Pair<Int, Int>) {
        when {
            matchCountPair.first == 0 -> nothingClassCount += 1
            matchCountPair.first == 1 -> nothingClassCount += 1
            matchCountPair.first == 2 -> nothingClassCount += 1
            matchCountPair.first == 3 -> fifthClassCount += 1
            matchCountPair.first == 4 -> fourthClassCount += 1
            matchCountPair.first == 5 && matchCountPair.second == 0 -> thirdClassCount += 1
            matchCountPair.first == 5 && matchCountPair.second == 1 -> secondClassCount += 1
            matchCountPair.first == 6 -> firstClassCount += 1
        }
    }


    fun printWinningHistory() {
        println(LottoProcessConstValue.WINNING_HISTORY)
    }

    fun printOneLine() {
        println(LottoProcessConstValue.ONE_LINE)
    }

    companion object {
        const val BONUS_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1이상 45이하의 정수 값이어야 합니다."
        const val WIN_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표를 기준으로 나누어, 6개의 1이상 45이하의 정수 값들이여야 합니다."
    }

}