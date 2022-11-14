package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoShop() {
    fun createLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_FIRST_VALUE, LOTTO_LAST_VALUE, LOTTO_SIZE).sorted()
    }
}