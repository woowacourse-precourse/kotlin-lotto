package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumber(numberIndex: Int): Int {
        return numbers[numberIndex]
    }

    fun doMatchCheck(targetNumber: Int): Boolean {
        if (numbers.contains(targetNumber)) {
            return true
        }
        return false
    }
}
