package lotto.model

import lotto.util.Constants.WINNING_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WINNING_NUMBER_COUNT)
    }

    // TODO: 당첨번호 및 보너스 번호와 비교해서 카운트 하는 기능
}
