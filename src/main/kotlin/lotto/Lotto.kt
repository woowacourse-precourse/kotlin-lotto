package lotto

import camp.nextstep.edu.missionutils.Console

//당첨 번호 입력하는 클래스
class Lotto(private val numbers: List<Int>) {
    //6개 정수
    init {
        require(numbers.size == 6) {
            Exception.COUNT.message
        }
    }
    //중복검사
    fun checkOverlap() {
        val range = numbers.toMutableSet()
        require(range.size == 6) {
            Exception.DUPLICATION.message
        }
    }

    fun checkRange(winner: List<Int>) {
        require(winner.all { it in 1..45 }) {
            Exception.RANGE.message
        }
    }

}

enum class Exception(val message: String) {
    NUMBER("[ERROR] 로또 번호는 숫자로 이루어져야합니다."),
    RANGE("[ERROR] 로또 번호는 1~45까지의 숫자로 이루어져야합니다."),
    COUNT("[ERROR] 로또 번호는 6개의 숫자로 이루어져야합니다."),
    DUPLICATION("[ERROR] 로또 번호는 중복되지않은 숫자로 이루어져야합니다."),
    UNIT("[ERROR] 로또 번호는 중복되지않은 숫자로 이루어져야합니다."),
    ZERO("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야합니다."),
    CHARACTER("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야합니다."),
    BLANK("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야합니다."),
}