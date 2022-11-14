package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    // 1~45까지의 중복되지 않는 숫자 6개를 뽑아서 오름차순 정렬한 결과를 리턴한다.
    fun createLottoNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }

    // 구입 금액 만큼 로또를 추첨한 결과를 출력한다.
    fun printLottoList(tryNumber: Int) {
        println("${tryNumber}를 구매했습니다.")
        for(i in 0 until tryNumber){
            println(createLottoNumbers())
        }
    }
}