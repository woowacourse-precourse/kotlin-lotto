package lotto

import camp.nextstep.edu.missionutils.Randoms
import util.Game

class RandomLottoNumbers {
    fun printLottoNumbers(lottoCount: Int): MutableList<List<Int>> {
        val lottoNumbersList: MutableList<List<Int>> = mutableListOf()
        println(Game.LOTTO_COUNT.message.format(lottoCount))
        for (i in 0 until lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(lottoNumbers)
            lottoNumbersList.add(lottoNumbers)
        }
        return lottoNumbersList
    }
}