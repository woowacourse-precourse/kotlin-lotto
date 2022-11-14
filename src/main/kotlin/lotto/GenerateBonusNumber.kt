package lotto

import camp.nextstep.edu.missionutils.Console

class GenerateBonusNumber(private val winningNumbers: Lotto) {
    fun inputBonusNumber() : Int {
        println("\n보너스 번호를 입력해 주세요.")
        val inputBonus = Console.readLine()!!.toInt()

        checkException(inputBonus)

        return inputBonus
    }

    private fun checkException(inputBonus : Int) {
        val regex = Regex("-?\\d+(\\.\\d+)?")

        if(inputBonus !in 1 .. 45) throw IllegalArgumentException(ERROR_LENGTH)
        if(!regex.matches(inputBonus.toString())) throw IllegalArgumentException(ERROR_NOT_NUMBER)
        if(winningNumbers.getLottoNumbers().contains(inputBonus)) throw IllegalArgumentException(ERROR_DUPLICATE)
    }

    companion object {
        const val ERROR_LENGTH = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자이여야 합니다."
        const val ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력해 주세요."
        const val ERROR_DUPLICATE = "[ERROR] 당첨 번호와 중복된 숫자를 입력하셨습니다."
    }
}