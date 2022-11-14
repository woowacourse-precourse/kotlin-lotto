package lotto

import kotlin.math.round

class Consumer(private val money: Int) {
    var myLotto = mutableListOf<List<Int>>()

    init {
        require(money % WON_THOUSAND_UNIT == 0) { println("[ERROR] 1000원 단위가 아닙니다.") }
        require(money >= WON_THOUSAND_UNIT) { println("[ERROR] 돈이 부족합니다") }
    }

    fun buyLotto() {
        for (lottoCount in 0 until money / WON_THOUSAND_UNIT) {
            val lottoList = LottoShop().createLotto()
            myLotto.add(lottoList)
        }
    }

    fun compareLotto(winningNumbers: Lotto, bonusNumber: Int): List<Int> {
        return LottoCalculator(myLotto, winningNumbers, bonusNumber).calculateLotto()
    }

    fun calculateYield(winnings: List<Int>): String {
        var sum = 0
        sum = Winnings.FIRST_PLACE.sum(winnings[FIRST_PLACE_INDEX]) +
                Winnings.SECOND_PLACE.sum(winnings[SECOND_PLACE_INDEX]) +
                Winnings.THIRD_PLACE.sum(winnings[THIRD_PLACE_INDEX]) +
                Winnings.FOURTH_PLACE.sum(winnings[FOURTH_PLACE_INDEX]) +
                Winnings.FIFTH_PLACE.sum(winnings[FIFTH_PLACE_INDEX])
        return String.format(
            "%.1f",
            round(((sum * PERCENT_VALUE).toDouble() / money) * ROUND_POSITION) / ROUND_POSITION
        )
    }
}