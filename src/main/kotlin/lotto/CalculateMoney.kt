package lotto

import lotto.utils.CorrectNumber
import lotto.utils.Print
import lotto.view.Message

class CalculateMoney(private val winLotto: MutableMap<Int, Int>) {
    fun result(): Int = calculateMoney()

    private fun calculateMoney(): Int {
        var money = Print.ZERO
        winLotto.forEach { (lottoCount, countValue) ->
            money += countNumber(lottoCount, countValue) * countValue
        }
        return money
    }

    private fun countNumber(lottoCount: Int, countValue: Int): Int {
        return when (lottoCount) {
            Print.THREE -> {
                Message.showCorrect(Print.MATCH_THREE, countValue)
                CorrectNumber.THREE.getMoney()
            }
            Print.FOUR -> {
                Message.showCorrect(Print.MATCH_FOUR, countValue)
                CorrectNumber.FOUR.getMoney()
            }
            Print.FIVE -> {
                Message.showCorrect(Print.MATCH_FIVE, countValue)
                CorrectNumber.FIVE.getMoney()
            }
            Print.FIVE_BONUS -> {  // 숫자 5개와 보너스 숫자가 일치할때.
                Message.showCorrect(Print.MATCH_FIVE_BONUS, countValue)
                CorrectNumber.FIVE_AND_BONUS.getMoney()
            }
            Print.SIX -> {
                Message.showCorrect(Print.MATCH_SIX, countValue)
                CorrectNumber.SIX.getMoney()
            }
            else -> Print.ZERO
        }
    }
}
