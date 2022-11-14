package lotto.domain.model

import lotto.utils.Constants
import lotto.utils.Constants.BONUS_NOT_DUPLICATE_TEXT
import lotto.utils.Constants.ZERO

class WinningLottery(private val userWinningNum: String, private val userBonus: String) {

    private val winningNum = mutableListOf<Int>()
    private val bonus: Int

    init {
        validateWinningNum(userWinningNum).forEach {
            winningNum.add(it.toInt())
        }
        bonus = validateBonusNum(userBonus)
        require(!winningNum.contains(bonus)) {
            BONUS_NOT_DUPLICATE_TEXT
        }
    }

    fun compareLotto(lotto: Lotto): Rank {
        var count = ZERO
        winningNum.forEach {
            if (lotto.contains(it)) count++
        }
        return Rank.valueOf(count, lotto.contains(bonus))
    }

    private fun validateWinningNum(userInput: String): List<String> {
        val splitedNum = userInput.split(',')
        require(userInput.isNotBlank() && splitedNum.joinToString("").all { it.isDigit() }) {
            Constants.LOTTO_NUM_MUST_NUMBER_TEXT
        }
        require(splitedNum.all { it.toInt() in Constants.MIN_LOTTO_NUM..Constants.MAX_LOTTO_NUM }) {
            Constants.LOTTO_NUM_IN_RANGE_TEXT
        }
        return splitedNum
    }

    private fun validateBonusNum(userInput: String): Int {
        require(userInput.isNotBlank() &&
                userInput.all { Character.isDigit(it) }) {
            Constants.LOTTO_NUM_MUST_NUMBER_TEXT
        }
        require(userInput.toInt() in Constants.MIN_LOTTO_NUM..Constants.MAX_LOTTO_NUM) {
            Constants.LOTTO_NUM_IN_RANGE_TEXT
        }
        return userInput.toInt()
    }


}
