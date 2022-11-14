package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(numbers.distinct().size==6){"[ERROR] : 중복된 숫자가 있습니다"}
    }
}
