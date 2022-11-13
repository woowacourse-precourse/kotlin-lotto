package lotto

class ValidateInput {
    fun validateRange(number: String): Boolean {
        val num: Int = number.toInt()
        if (num<1 || num >45)
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        return true
    }

    fun validateNumber(input: String): Boolean {
        if (!input.all { Character.isDigit(it) })
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        return true
    }

    fun validateDuplication(winningNumbers: List<Int>): Boolean {
        if (winningNumbers.distinct().size != 6)
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        return true
    }

    fun validateDuplicationBonusNum(lottoNumber: Lotto, bonusNum: String): Boolean {
        if (lottoNumber.getNumbers().contains(bonusNum.toInt()))
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        return true
    }
}