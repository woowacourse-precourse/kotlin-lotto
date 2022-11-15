package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    companion object {
        fun getBonusNumber(): Int {
            val input = Console.readLine()
            val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.")
            if (bonusNumber < 1 || bonusNumber > 45)
                throw IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.")
            return bonusNumber
        }

        fun getWinNumbers(): List<Int> {
            val input = Console.readLine().split(",")

            if (input.size != 6)
                throw IllegalArgumentException("로또 번호는 6개만 입력되어야 합니다.")

            val winNumbers = input.map {
                val number = it.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자여야 합니다.")
                if (number < 1 || number > 45)
                    throw IllegalArgumentException("로또 번호는 1에서 45 사이의 숫자여야 합니다.")
                number
            }

            return winNumbers
        }

        fun getLottoMoney(): Int {
            val input = Console.readLine()
            val lottoMoney = input.toIntOrNull() ?: throw IllegalArgumentException("구매 금액은 숫자로만 이루어져야 합니다.")

            if (lottoMoney % 1000 != 0)
                throw IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.")

            return lottoMoney
        }
    }
}