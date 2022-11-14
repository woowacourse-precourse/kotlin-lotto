package lotto

class LottoWin {

    private var wonLotto = mutableListOf<Int>(0,0,0,0,0)

    fun calPrize(purchasedLotto: List<Lotto>, lottoWinningNumbers: List<Int>, lottoBonus: Int): Int {
        var prize = 0
        for (i in purchasedLotto) {
            when (winningLotto(i.getLottoNumbers(), lottoWinningNumbers, lottoBonus)) {
                LottoPrize.FIRST -> {
                    prize += LottoPrize.FIRST.prize
                    wonLotto[4]++
                }
                LottoPrize.SECOND -> {
                    prize += LottoPrize.SECOND.prize
                    wonLotto[3]++
                }
                LottoPrize.THIRD -> {
                    prize += LottoPrize.THIRD.prize
                    wonLotto[2]++
                }
                LottoPrize.FOURTH -> {
                    prize += LottoPrize.FOURTH.prize
                    wonLotto[1]++
                }
                LottoPrize.FIFTH -> {
                    prize += LottoPrize.FIFTH.prize
                    wonLotto[0]++
                }
                else -> {}
            }
        }
        return prize
    }

    fun winningLotto(purchasedLotto: List<Int>, lottoWinningNumbers: List<Int>, lottoBonus: Int): LottoPrize {
        var winCount = 0
        var isBonus: Boolean = false
        for(i in purchasedLotto.sorted()) {
            when {
                lottoWinningNumbers.contains(i) -> winCount++
                i == lottoBonus -> isBonus = true
            }
        }
        return lottoRank(winCount, isBonus)
    }

    fun lottoRank(winCount: Int, isBonus: Boolean): LottoPrize {
        return when (winCount) {
            6 -> LottoPrize.FIRST
            5 -> {
                if (isBonus) LottoPrize.SECOND
                else LottoPrize.THIRD
            }
            4 -> LottoPrize.FOURTH
            3 -> LottoPrize.FIFTH
            else -> LottoPrize.NONE
        }
    }

}