package lotto.service

interface CheckContain{
    fun containLottoNum(winningNumber: String, lottoNumber: List<Int>): Int
    fun containBonusNum(checkWinningNumber: Int, lottoNumber: List<Int>, bonus: Int): Int
}
class CheckContainImpl : CheckContain{
    override fun containLottoNum(winningNumber: String, lottoNumber: List<Int>): Int {
        val winningNumbers = winningNumber.split(",")
        var checkWinningNumber = 0
        for (userLottoNumber in winningNumbers) {
            if (lottoNumber.contains(userLottoNumber.toInt())) {
                checkWinningNumber++
            }
        }
        return checkWinningNumber
    }

    override fun containBonusNum(checkWinningNumber: Int, lottoNumber: List<Int>, bonus: Int): Int {
        var checkWinning = checkWinningNumber
        if (checkWinning == 5) {
            if (lottoNumber.contains(bonus)) {
                checkWinning += 2
            }
        }
        return checkWinningNumber
    }
}