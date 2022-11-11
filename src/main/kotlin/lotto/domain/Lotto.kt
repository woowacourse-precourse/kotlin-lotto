package lotto.domain

import lotto.Exceptions

class Lotto(private val numbers: List<Int>) {
    init {
        Exceptions().validateLottoNumbers(numbers)
    }

    // TODO: 추가 기능 구현
}
