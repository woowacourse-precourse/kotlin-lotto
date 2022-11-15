package lotto.domain

import camp.nextstep.edu.missionutils.Console

class InputNumberCheck() {

    var test = 0
    fun inputError(): Int {

        try {
            test = Console.readLine().toInt()
            if ((test % 1000 != 0) && (test != 0)) {
                println("[ERROR] 구입 금액은 1000원 단위입니다.")
                throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.")
            }

        } catch (_: NumberFormatException) {
            println("[ERROR] 숫자가 아닌 수가 입력되었습니다.")
            throw IllegalArgumentException("[ERROR] 숫자가 아닌 수가 입력되었습니다.")
        }
        return test
    }
}