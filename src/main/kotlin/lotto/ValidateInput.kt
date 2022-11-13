package lotto

import lotto.Model.Lotto

class ValidateInput {
    fun validateRange(number: Int): Boolean {
        if (number<1 || number>45)
            throw IllegalArgumentException()
        return true
    }

    fun validateNumber(input: String): Boolean {
        if (!input.all { Character.isDigit(it) })
            throw IllegalArgumentException()
        return true
    }

    fun validateDuplication(winningNumbers: List<Int>): Boolean {
        if (winningNumbers.distinct().size != 6)
            throw IllegalArgumentException()
        return true
    }

    fun validateDuplicationBonusNum(lottoNumber: Lotto, bonusNum: Int): Boolean {
        if (lottoNumber.getNumbers().contains(bonusNum))
            throw IllegalArgumentException()
        return true
    }
}