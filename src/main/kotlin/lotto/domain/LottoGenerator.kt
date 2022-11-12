package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun issueLotto(): Lotto {
        var lottoNum: MutableList<Int>
        while (true) {
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            if (nums.distinct().size == 6) {
                lottoNum = nums
                break
            }
        }
        lottoNum.sort()
        return Lotto(lottoNum)
    }
}