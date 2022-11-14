package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { println("[ERROR] 6개의 숫자가 아닙니다.") }
        require(!checkDuplication()) { println("[ERROR] 중복된 숫자가 있습니다.") }
    }

    private fun checkDuplication(): Boolean {
        return numbers.distinct().size < LOTTO_SIZE
    }

    fun contains(number : Int) : Boolean{
        return numbers.contains(number)
    }
}
