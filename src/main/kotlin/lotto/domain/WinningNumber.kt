package lotto.domain

class WinningNumber(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { LOTTO_SIZE_EXCEPTION }
        require(winningNumbers.distinct().size == 6) { LOTTO_DUPLICATE_EXCEPTION }
        require(winningNumbers.all { it in 1..45 }) { LOTTO_RANGE_EXCEPTION }
        require(bonusNumber !in winningNumbers) { LOTTO_DUPLICATE_EXCEPTION }
        require(bonusNumber in 1..45 ) { LOTTO_RANGE_EXCEPTION }
    }

    fun numbers(): List<Int> {
        return winningNumbers
    }

    fun bonus(): Int {
        return bonusNumber
    }

    companion object{
        const val LOTTO_SIZE_EXCEPTION = "[ERROR] 로또 번호의 갯수는 6개 입니다."
        const val LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 로또 번호는 중복이 있으면 안됩니다."
        const val LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
