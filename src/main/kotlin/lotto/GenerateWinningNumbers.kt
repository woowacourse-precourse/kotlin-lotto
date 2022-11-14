package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GenerateWinningNumbers {
    fun inputWinningNumbers() : Lotto {
        println("당첨 번호를 입력해 주세요.")
        val inputNumber = Console.readLine().split(',')
        val winningNumber = inputNumber.map {
            val number = it.toInt()
            if(number !in 1 .. 45) throw IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자이여야 합니다.")

            number
        }

        return Lotto(winningNumber)
    }

    fun inputBonusNumber() : Int {
        println("보너스 번호를 입력해 주세요.")
        val inputNumber = Console.readLine()!!
        val bonusNumber = inputNumber.toInt()

        return bonusNumber
    }
}