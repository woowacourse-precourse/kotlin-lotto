package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6자리의 숫자여야 합니다." }
    }

    // TODO: 추가 기능 구현
}
