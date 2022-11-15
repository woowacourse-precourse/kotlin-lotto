package lotto

class LottoCompare(private val winnerNumber: List<Int>, private val bonusNumber: Int) {
    private fun compareWinnerNumber(userLottoNumber: List<Int>): Int {
        var rightCount = 0

        userLottoNumber.forEach {
            if(winnerNumber.contains(it))
                rightCount += 1
        }
        return rightCount
    }

    fun compareLotto(userLottoNumber:List<Int>): LottoResult {
        var rightCount = compareWinnerNumber(userLottoNumber)

        if(userLottoNumber.contains(bonusNumber) && rightCount < 5)
            rightCount += 1

        if(rightCount == 3)
            return LottoResult.THREE

        if(rightCount == 4)
            return LottoResult.FOUR

        if(rightCount == 5 && userLottoNumber.contains(bonusNumber))
            return LottoResult.FIVE_BONUS

        if(rightCount == 5)
            return LottoResult.FIVE

        if(rightCount == 6)
            return LottoResult.SIX

        return LottoResult.NOTHING
    }
}