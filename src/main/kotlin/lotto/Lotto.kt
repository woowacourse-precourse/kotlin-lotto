package lotto

private const val LOTTO_SIZE = 6

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (isValidLottoNumbers().not()) {
            throw IllegalArgumentException("[ERROR]")
        }
    }

    fun getMatchingNumberCount(myLotto: List<Int>): Int {
        return myLotto.map { number ->
            numbers.contains(number)
        }.count { it }
    }

    private fun isValidLottoNumbers(): Boolean {
        if (numbers.size != LOTTO_SIZE || numbers.toSet().size != LOTTO_SIZE) {
            return false
        }

        return true
    }
}