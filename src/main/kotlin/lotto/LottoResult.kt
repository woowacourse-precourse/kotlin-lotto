package lotto

import lotto.utils.Print
import lotto.view.Message

class LottoResult(
    private val createNumbers: MutableList<List<Int>>,
    private val inputPrice: Int
) {
    fun result(inputNumbers: List<String>, bonusNumber: String) {
        Message.showTitle()
        calculateLotto(inputNumbers, bonusNumber)
        val finalMoney = CalculateMoney(lottoCount).result()
        //수익률 계산 클래스
        EarningsRate(finalMoney, inputPrice).result()
    }

    private fun calculateLotto(inputNumbers: List<String>, bonusNumber: String) {
        createNumbers.forEach { lottoNumbers ->
            var isBonus = false
            if (lottoNumbers.contains(bonusNumber.toInt())) {
                isBonus = true
            }
            val count = lottoNumbers.count { inputNumbers.contains(it.toString()) }
            if (lottoCount.containsKey(count)) {
                countLotto(count, isBonus)
            }
        }
    }

    private fun countLotto(count: Int, isBonus: Boolean) {
        val countOne = 1
        if (count == Print.FIVE && isBonus) {
            lottoCount[Print.FIVE_BONUS] = lottoCount.getValue(Print.FIVE_BONUS) + countOne
        } else {
            lottoCount[count] = lottoCount.getValue(count) + countOne
        }
    }

    companion object {
        val lottoCount =
            with(Print) {
                mutableMapOf(THREE to ZERO, FOUR to ZERO, FIVE to ZERO, FIVE_BONUS to ZERO, SIX to ZERO)
            }
    }
}
