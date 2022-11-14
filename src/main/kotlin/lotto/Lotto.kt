package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] 로또 번호는 6개의 숫자로 이루어져 있습니다."}
        require(numbers.distinct()==numbers) {"[ERROR] 로또 번호는 서로 다른 숫자로 이루어져 있습니다."}
        for (i in numbers) {
            require(i in 0..45) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        }
    }

    fun print() {
        println(numbers)
    }

    fun list(): List<Int> {
        return numbers
    }

    // TODO: 추가 기능 구현
}
