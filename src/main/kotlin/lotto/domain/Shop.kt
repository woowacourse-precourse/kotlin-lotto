package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Shop {

    fun buyLotto(price: Int): List<List<Int>> {
        val lotto = mutableListOf<List<Int>>()
        repeat(price / 1000) {
            lotto.add(getRandomNumbers())
        }

        return lotto.toList()
    }

    private fun getRandomNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}