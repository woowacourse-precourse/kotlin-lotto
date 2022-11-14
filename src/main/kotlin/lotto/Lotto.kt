package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>){
    init {
        require(numbers.size == 6){"[ERROR] 로또는 6자리로 구성되어 있어야 합니다."}
        require(numbers.distinct().size==6){"[ERROR] 로또는 중복되지 않는 수로 구성되어 있어야 합니다."}
    }
    fun lottoNumbers() : List<Int>{
        return numbers
    }
}
