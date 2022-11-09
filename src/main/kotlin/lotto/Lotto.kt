package lotto

import lotto.Constant.Companion.lottoSize

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == lottoSize)
    }


    // TODO: 추가 기능 구현
}
