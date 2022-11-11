package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(checkDuplication()) { println("[ERROR] 중복된 숫자가 있습니다.") }
    }

    private fun checkDuplication(): Boolean {
        return numbers.filter {
            numbers.contains(it)
        }.count() <= 1
    }
}
