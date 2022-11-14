package lotto.domain.model

import lotto.controller.LottoController.Companion.ERROR_MESSAGE

class WinningLottery(private val winningNum: String, private val bonus: Int) {

    private val numbers = mutableListOf<Int>()

    init {
        val userInput = validateWinningNum(winningNum)
        userInput.forEach {
            numbers.add(it.toInt())
        }
    }

    fun compareLotto(lotto: Lotto): Rank {
        var count = 0
        numbers.forEach {
            if (lotto.contains(it)) count += 1
        }
        return Rank.valueOf(count, lotto.contains(bonus))
    }

    private fun validateWinningNum(userInput: String): List<String> {
        val splitedNum = userInput.split(',')
        require(userInput.isNotBlank() && splitedNum.joinToString("").all { it.isDigit() }) {
            "$ERROR_MESSAGE 로또 번호는 숫자로 입력해 주세요."
        }
        require(splitedNum.all { it.toInt() in 1..45 }) {
            "$ERROR_MESSAGE 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        return splitedNum
    }

}
