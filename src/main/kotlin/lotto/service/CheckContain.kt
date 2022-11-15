package lotto.service

class CheckContain {
    fun containLottoNum(winningNumber: String, lottoNumber: List<Int>): Int {
        val winningNumbers = winningNumber.split(",")
        var checkWinningNumber = 0
        for (userLottoNumber in winningNumbers) {
            if (lottoNumber.contains(userLottoNumber.toInt())) {
                checkWinningNumber++
            }
        }
        return checkWinningNumber
    }

    fun containBonusNum(checkWinningNumber: Int, lottoNumber: List<Int>, bonus: Int): Int {
        var checkWinning = checkWinningNumber
        if (checkWinning == 5) {
            if (lottoNumber.contains(bonus)) {
                checkWinning += 2
            }
        }
        return checkWinningNumber
    }
}