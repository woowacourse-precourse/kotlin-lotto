package lotto.domain

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] 입력은 6개만 있어야합니다." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] 중복된 숫자가 있으면 안됩니다." }
        require(winningNumbers.filter { it in 1..45 }.size == 6) { "[ERROR] 로또 번호는 1부터 45까지 사이의 숫자여야 합니다." }

        require(bonusNumber in 1..45) { "[ERROR] 로또 번호는 1부터 45까지 사이의 숫자여야 합니다." }
        require(bonusNumber !in winningNumbers) { "[ERROR0] 중복된 숫자가 있으면 안됩니다." }
    }

    fun checkResult(guessNumber: List<Int>): Pair<Int, Boolean> {
        return Pair(
            winningNumbers.countSameNumbers(guessNumber),
            bonusNumber in guessNumber
        )
    }

    fun getPrize(guessNumber: List<Int>): Int {
        val (countSame, bonus) = checkResult(guessNumber)
        return LottoRank.of(countSame, bonus).prize
    }

    fun getRank(guessNumber: List<Int>): Int {
        val (countSame, bonus) = checkResult(guessNumber)
        return LottoRank.of(countSame, bonus).ordinal + 1
    }

    private fun List<Int>.countSameNumbers(guess: List<Int>): Int {
        return this.filter { it in guess }.size
    }
}
