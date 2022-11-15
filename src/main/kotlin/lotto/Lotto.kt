package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(numbers.distinct().size==6){"[ERROR] : 숫자가 중복되어 있습니다."}
        require(numbers[5] <= 45){"[ERROR] : 숫자가 45를 초과했습니다."}
        require(numbers[0] >= 1){"[ERROR] : 숫자가 1보다 작습니다."}
    }
}
