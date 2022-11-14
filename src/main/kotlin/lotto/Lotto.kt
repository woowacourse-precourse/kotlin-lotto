package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        val distinctedNumbers = numbers.distinct()
        require(distinctedNumbers.size==6) { "[ERROR] 로또에는 중복되는 값이 없어야 합니다." }
        require(numbers.size == 6)
        for (number in 0..5){
            if (numbers[number] !in 1..45){
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }
}
