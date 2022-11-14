package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        LottoCheckError(numbers).checkLottoThrowException()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun print() {
        println(numbers.toString())
    }

    fun isContainedNumber(number: Int) = numbers.contains(number)
}
