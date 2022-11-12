package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        lottoCreate()
    }
    fun lottoCreate(){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers.sorted())
    }
    // TODO: 추가 기능 구현
}


