package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerate {
    fun createLottoNumbers() : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}