package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printLotto() {
        numbers.sorted()
        println(numbers)
    }

    fun printResult(lottoNumber: List<Int>, bonusNUmber: Int): LottoWinningPlace {
        val correctNum = numbers.count { lottoNumber.contains(it) }

        when (correctNum) {
            6 -> return LottoWinningPlace.FIRST
            4 -> return LottoWinningPlace.FOURTH
            3 -> return LottoWinningPlace.FIFTH
        }

        if (correctNum == 5)
            if (numbers.contains(bonusNUmber)) return LottoWinningPlace.SECOND
        return LottoWinningPlace.THIRD

    }
}
