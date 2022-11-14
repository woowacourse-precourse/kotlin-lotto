package lotto

class Lotto(private val numbers: List<Int>) {

    enum class functions {
        checkResult(), checkLottoNumRepeat()
    }
    init {
        require(numbers.size == 6)
        checkLottoNumRepeat()
    }

    fun checkResult(lottoNums: Array<Int>) {
        val different = lottoWinNum.toSet().minus(lottoNums.toSet()) // 당첨 번호와 선정된 번호 중 겹치지 않는 숫자 구하기
        val winCount = lottoWinNum.size - different.size

        if (winCount == 3) threeWin += 1
        if (winCount == 4) fourWin += 1
        if (winCount == 5) {
            if (different.contains(bonusNum)) fiveBonusWin += 1
            else fiveWin += 1
        }
        if (winCount == 6) sixWin += 1
    }

    fun checkLottoNumRepeat() {
        if (numbers.size > numbers.toSet().size) throw IllegalArgumentException()
    }
}
