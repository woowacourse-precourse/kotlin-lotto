package lotto.domain


class Lotto(private val numbers: List<Int>) {

    enum class Information(val number: Int) {
        SIZE(6),
        PRICE(1000)
    }

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == Information.SIZE.number)
    }

    fun contains(number: Int): Boolean {
        if (numbers.contains(number)) {
            return true
        }
        return false
    }

    fun getValue(index: Int): Int {
        return numbers[index]
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

}
