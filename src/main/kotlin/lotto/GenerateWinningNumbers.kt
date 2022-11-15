package lotto

import camp.nextstep.edu.missionutils.Console

class GenerateWinningNumbers {
    fun inputWinningNumbers() : Lotto {
        println(INPUT_MESSAGE)
        val inputNumber = Console.readLine().split(',')

        val winningNumber = inputNumber.map {
            val number = it.toInt()
            checkWinningNumbers(it)
            number
        }

        return Lotto(winningNumber)
    }

    private fun checkWinningNumbers(inputNumbers: String) {
        val regex = Regex("-?\\d+(\\.\\d+)?")
        if(inputNumbers.toInt() !in 1 .. 45) throw IllegalArgumentException(ERROR_LENGTH)

        inputNumbers.forEach {
            if(!regex.matches(it.toString())) throw IllegalArgumentException(ERROR_NOT_NUMBER)
        }
    }
    companion object {
        const val INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val ERROR_LENGTH = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자이여야 합니다."
        const val ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력해 주세요."
    }

}