package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoShop() {
    fun createLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}