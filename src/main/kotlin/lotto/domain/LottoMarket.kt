package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMarket {
    private val lottos = mutableListOf<List<Int>>()

    fun buyLottos(numberOfLotto: Long): List<List<Int>> {
        for (index in 0 until numberOfLotto) {
            lottos.add(createLotto())
        }
        return lottos.toList()
    }

    fun createLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, THE_NUMBER_OF_LOTTO_NUMBERS)
            .sorted()
    }

    fun getTheNumberOfLotto(purchasingAmount: Long): Long {
        return purchasingAmount / 1000
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val THE_NUMBER_OF_LOTTO_NUMBERS = 6
    }

}