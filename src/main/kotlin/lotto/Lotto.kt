package lotto


class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { NOT_SIX_NUMBERS }
        require(numbers.distinct().size == 6) { DUPLICATED_NUMBERS }
        require(correctNumbers(numbers)) { "[ERROR] 입력된 수가 로또번호가 아닙니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    private fun correctNumbers(numbers: List<Int>): Boolean {
        for (number in numbers) {
            if (number !in 1..45) return false
        }
        return true
    }

    companion object {
        const val NOT_SIX_NUMBERS = "[ERROR] 입력된 수가 6자리가 아닙니다."
        const val DUPLICATED_NUMBERS = "[ERROR] 중복된 숫자가 있습니다."
    }

}
