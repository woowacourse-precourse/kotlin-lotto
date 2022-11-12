package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkNumberDuplicate()
    }

    private fun checkNumberDuplicate() {
        for (i in 0..4) {
            for (j in i + 1..5) {
                if (numbers[i] == numbers[j]) {
                    throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
                }
            }
        }
    }
}
