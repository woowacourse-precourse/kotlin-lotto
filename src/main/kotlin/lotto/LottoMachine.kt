package lotto

import camp.nextstep.edu.missionutils.Console.readLine

const val INVALID_NUMBER_RANGE = "입력된 숫자가 1에서 45사이가 아닙니다."

class LottoMachine {
    private val _winningNumbers = mutableListOf<Int>()
    val winningNumbers: List<Int> get() = _winningNumbers

    private var _bonusNumber: Int = 0
    val bonusNumber: Int get() = _bonusNumber

    fun enterWinningNumber(input: String = readLine()) {}

    fun enterBonusNumber(number: String = readLine()) {}
}
