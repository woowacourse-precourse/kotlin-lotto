package lotto.domain

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto

object GenerateLotto {

    fun generate(): Lotto {
        return Lotto(pickUniqueNumbersInRange(1, 45, 6))
    }

    fun stringToList(string: String): Lotto {
        val stringLotto = string.split(',')
        val intLotto = mutableListOf<Int>()

        for (i in stringLotto) {
            intLotto.add(i.toInt())
        }

        return Lotto(intLotto)
    }

    fun bonusNumber(string: String, lotto: Lotto): Int {
        val number = string.toInt()

        require(number in 1..45) {"[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."}
        if (number in lotto.list()) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.")
        }

        return number
    }

}