package lotto.domain

import lotto.ui.ConstMessage
import java.text.DecimalFormat

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
        printWinStats(wonLotto)
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

    fun printWinStats(wonLotto: List<Int>) {
        val dec = DecimalFormat("#,###")
        print(ConstMessage.WIN_STATS)
        var i = 0
        LottoPrize.values().forEachIndexed { index, winStats ->
            if(index < 5) {
                println("${winStats.matchCount}개 일치${winStats.bonusBall} (${dec.format(winStats.prize)}원) - ${wonLotto[i++]}개")
            } else if(index > 5) {
                return
            }
        }
    }

    fun printProfitRate(lottoPurchasePrice: Int, winPrize: Int) {//수익률 계산
        var profitRate : Double = (winPrize.toDouble() * 100)/lottoPurchasePrice.toDouble()
        val saveRoundDigit = roundDigit(profitRate, 1)
        println("총 수익률은 $saveRoundDigit%입니다.")
    }

    // 반올림 함수
    fun roundDigit(number: Double, digits: Int): Double {
        return Math.round(number * Math.pow(10.0, digits.toDouble())) / Math.pow(10.0, digits.toDouble())
    }

}