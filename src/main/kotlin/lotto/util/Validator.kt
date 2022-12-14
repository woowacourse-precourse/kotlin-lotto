package lotto.util

import lotto.model.LottoData.winningLotto
import java.lang.IllegalArgumentException

object Validator {
    fun checkMoney(money: String) {
        if (money.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        }
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        }
    }

    fun checkWinningNumber(number: String): List<Int> {
        val winningNumber = mutableListOf<Int>()
        number.split(',').forEach {
            it.toIntOrNull()?.let { winningNumber.add(it) }
        }
        if (winningNumber.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 콤마로 구분해 입력해주세요.")
        }
        for (number in winningNumber) {
            if (number !in 1..45) {
                throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.")
            }
        }
        return winningNumber.sorted().toList()
    }

    fun checkBonusNumber(number: String) {
        if (number.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        }
        if (number.toInt() !in 1..45) {
            throw IllegalArgumentException("[ERROR] 1~45 사이 숫자를 입력해주세요.")
        }
    }

    fun checkBonusInNumber(bonus: Int, winningNumber: List<Int>) {
        if (bonus in winningNumber) {
            throw IllegalArgumentException("[ERROR] 당첨 번호에 없는 숫자를 입력해주세요.")
        }
    }
}