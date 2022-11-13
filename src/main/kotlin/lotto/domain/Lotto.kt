package lotto.domain


class Lotto(private val numbers: List<Int>) {
    enum class LottoInformation(val number: Int) {
        LOTTO_SIZE(6),
        LOTTO_PRICE(1000)
    }

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == LottoInformation.LOTTO_SIZE.number)
    }

    fun contains(number: Int): Boolean {
        if (numbers.contains(number)) {
            return true
        }
        return false
    }

    fun getValues(index: Int): Int {
        return numbers[index]
    }

    fun print(): List<Int> {
        return numbers
    }

}
