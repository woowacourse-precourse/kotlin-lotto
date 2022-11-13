package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    // 1~45까지의 중복되지 않는 숫자 6개를 뽑아서 오름차순 정렬한 결과를 리턴한다.
    fun createLottoNumber(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }
}