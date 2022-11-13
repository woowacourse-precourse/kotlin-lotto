package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class CreateLotto {
    fun createRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}