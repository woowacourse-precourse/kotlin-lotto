package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoStaff() {

    fun countLotto(amount: Int): Int {
        return amount / LOTTO_PRICE
    }

    fun generateLotto():Lotto{
        val numbers=Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers.sorted())
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}