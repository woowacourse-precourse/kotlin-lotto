package lotto.domain

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Util {
    fun createLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun readLine(): String {
        return Console.readLine().trim()
    }
}