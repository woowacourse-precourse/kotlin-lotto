package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개가 필요합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(numbers.first() >= 1) { "[ERROR] 1보다 작은 번호가 있어서는 안됩니다." }
        require(numbers.last() <= 46) { "[ERROR] 46보다 큰 번호가 있어서는 안됩니다." }
    }

    // TODO: 추가 기능 구현
}
