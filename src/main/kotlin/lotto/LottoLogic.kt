package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoLogic {

    private var userLotto = mutableListOf<Int>()

    fun lottoGenerator(): List<Int>{
        userLotto.clear()
        userLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        userLotto.sort()
        return userLotto
    }
}