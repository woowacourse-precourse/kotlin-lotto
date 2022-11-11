package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6자리의 숫자여야 합니다." }
        require(numbers==numbers.distinct()){"[ERROR] 로또 번호는 중복이 없어야 합니다." }
    }

    fun lottocheck(numbers:List<Int>, ){

    }
}
