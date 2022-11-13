package lotto.domain

class LottoCheck {

    fun compareLotto(userNumber: List<Lotto>): List<Int> {
        val ranking = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (lotto in userNumber) {
            when (correctLotto(lotto.getNumbers())) {
                LottoReward.FIRST -> ranking[4]++
                LottoReward.SECOND -> ranking[3]++
                LottoReward.THIRD -> ranking[2]++
                LottoReward.FOURTH -> ranking[1]++
                LottoReward.FIFTH -> ranking[0]++
                else -> {}

            }
        }
        return ranking
    }

    fun correctLotto(userLotto: List<Int>): LottoReward {
        val lottoWinBall = lottoWinNumbers()
        val lottoBonusBall = lottoBonusNumbers()
        var winCnt: Int = 0
        var winBonus: Boolean = false

        for (lotto in userLotto) {
            if (lottoWinBall.contains(lotto)) winCnt++
            if (lotto == lottoBonusBall) winBonus = true
        }

        return rankLotto(winCnt, winBonus)
    }

    fun rankLotto(winBallCnt: Int, bonusBallCnt: Boolean): LottoReward {
        return when (winBallCnt) {
            6 -> LottoReward.FIRST
            5 -> {
                if (bonusBallCnt) LottoReward.SECOND
                else LottoReward.THIRD
            }

            4 -> LottoReward.FOURTH
            3 -> LottoReward.FIFTH
            else -> LottoReward.NOTHING
        }
    }

    fun lottoWinNumbers(): List<Int> {
        val winNumbers = mutableListOf<Int>()
        for (i in 0 until LottoWinBall.values().size - 1) {
            winNumbers.add(LottoWinBall.values()[i].num)
        }

        return winNumbers
    }

    fun lottoBonusNumbers(): Int = LottoWinBall.values()[5].num
}