package lotto

import camp.nextstep.edu.missionutils.Randoms

class MakeLottos {
    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}