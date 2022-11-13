package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    // 구입 금액에 해당하는 만큼 로또 번호를 뽑는다.
    fun createLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}