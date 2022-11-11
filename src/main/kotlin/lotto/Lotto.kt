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
    fun countCompareLotto(answer: Lotto): Int {
        val union = numbers + answer.numbers
        val intersection = union.groupBy { it }.filter { it.value.size > 1}.flatMap { it.value }.distinct()

        return intersection.size
    }

    fun matchBonus(bonus: Int): Boolean = numbers.contains(bonus)

    fun printLotto() {
        println(numbers)
    }
}
