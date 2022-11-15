package lotto.domain

import camp.nextstep.edu.missionutils.Console

class InputNumberCheck() {

    fun inputError(): Int {
        var input = 0
        try {
            input = Console.readLine().toInt()
            if ((input % 1000 != 0) && (input != 0)) {
                throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자가 아닌 수가 입력되었습니다.")
        }

        return input
    }
}