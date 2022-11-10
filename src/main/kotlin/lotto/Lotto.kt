package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
        numbers.forEach { num ->
            require(1 <= num && num <= 45) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        }
    }

    // TODO: 추가 기능 구현
}
