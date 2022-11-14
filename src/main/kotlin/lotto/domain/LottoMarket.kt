package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMarket {

    private fun createLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, THE_NUMBER_OF_LOTTO_NUMBERS).sorted()
    }

    companion object{
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val THE_NUMBER_OF_LOTTO_NUMBERS = 6
    }

}