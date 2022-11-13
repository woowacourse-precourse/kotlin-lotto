package domain

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개야 합니다." }
        numbers.forEach { require(it in 1..45) { "로또의 각 번호는 1~45 사이여아 합니다." } }
    }

    fun countSameNumber(lotto: Lotto): Int {
        val differences = numbers.toMutableList()
        differences.removeAll(lotto.numbers)
        return 6 - differences.size
    }
    operator fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}
