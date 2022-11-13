package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 입력은 6개만 있어야합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 중복된 숫자가 있으면 안됩니다." }
        require(numbers.filter { it in 1..45 }.size == 6) { "[ERROR] 로또 번호는 1부터 45까지 사이의 숫자여야 합니다." }
    }

    fun toList(): List<Int> = numbers
}
