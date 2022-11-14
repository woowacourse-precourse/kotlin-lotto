package lotto

import lotto.constants.Print

class LottoResult(
    private val createNumbers: MutableList<List<Int>>,
    private val inputPrice: Int
) {
    fun result(inputNumbers: List<String>, bonusNumber: String) {
        showTitleMessage()
        val winLotto = calculateLotto(inputNumbers, bonusNumber)
        val finalMoney = CalculateMoney(winLotto).result()
        //수익률 계산 클래스
        EarningsRate(finalMoney, inputPrice).result()
    }

    private fun showTitleMessage() {
        println(Print.RESULT_TITLE)
        println("---")
    }

    private fun calculateLotto(inputNumbers: List<String>, bonusNumber: String): MutableMap<Int, Int> {
        val lottoCount =
            with(Print) {
                mutableMapOf(THREE to ZERO, FOUR to ZERO, FIVE to ZERO, FIVE_BONUS to ZERO, SIX to ZERO)
            }
        createNumbers.forEach { lottoNumbers ->
            var isBonus = false
            if (lottoNumbers.contains(bonusNumber.toInt())) {
                isBonus = true
            }
            val count = lottoNumbers.count { inputNumbers.contains(it.toString()) }
            if (lottoCount.containsKey(count)) {
                countLotto(count, isBonus, lottoCount)
            }
        }
        return lottoCount
    }

    private fun countLotto(count: Int, isBonus: Boolean, lottoCount: MutableMap<Int, Int>) {
        val countOne = 1
        if (count == Print.FIVE && isBonus) {
            lottoCount[Print.FIVE_BONUS] = lottoCount.getValue(Print.FIVE_BONUS) + countOne
        } else {
            lottoCount[count] = lottoCount.getValue(count) + countOne
        }
    }
}
