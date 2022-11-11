package lotto

class LottoCheck {

    enum class LottoReward(val cnt: Int, val prize: String) {
        FIRST(6, "2,000,000,000"),
        SECOND(5, "30,000,000"),
        THIRD(5, "1,500,000"),
        FOURTH(4, "50,000"),
        FIFTH(3, "5,000"),
        NOTHING(0, "0")
    }

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
        for (i in 0 until LottoWin.LottoWinBall.values().size - 1) {
            winNumbers.add(LottoWin.LottoWinBall.values()[i].num)
        }

        return winNumbers
    }

    fun lottoBonusNumbers(): Int = LottoWin.LottoWinBall.values()[5].num
}