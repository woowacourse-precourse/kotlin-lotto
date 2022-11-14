package lotto

import camp.nextstep.edu.missionutils.Randoms

class OutputLotto {

    fun issueLotto(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}