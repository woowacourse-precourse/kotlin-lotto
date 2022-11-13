package lotto

import camp.nextstep.edu.missionutils.Randoms
import utils.Messages.ANSWER_NUMBERS_MESSAGE
import utils.Messages.BUY_PRICE_INQUIRE_MESSAGE
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_LOTTO_INPUT
import utils.Messages.BUY_AMOUNT_MESSAGE

class LottoGame {

    fun buyPriceInquireMessage() {
        println(BUY_PRICE_INQUIRE_MESSAGE)
    }

    fun inputPrice(): Int {
        return readLine()!!.toInt()
    }

    fun calculateNumberOfLotto(lottoInputPrice: Int): Int {
        return lottoInputPrice / 1000
    }

    fun checkRightLotto(lottoInputPrice: Int ): Boolean {
        val numOfRestLotto = lottoInputPrice % 1000
        if (numOfRestLotto != 0) {
            return false
        }
        return true
    }

    fun resultRightLotto (flag: Boolean) {
        if (!flag) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_LOTTO_INPUT)
    }

    fun tellNumOfLotto(numOfLotto: Int) {
        println("$numOfLotto"+BUY_AMOUNT_MESSAGE)
    }

    fun generateRandomLottos(numOfLotto: Int): MutableList<List<Int>> {
        val lottos = mutableListOf<Int>()
        var doubleLottos = mutableListOf<List<Int>>()
        for (i in 1..numOfLotto){
            val pickLottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.addAll(pickLottoNums)
        }
        doubleLottos = lottos.chunked(6).toMutableList()
        return doubleLottos
    }

    fun printEachLotto(doubleLottos: MutableList<List<Int>>){
        for (i in 0..doubleLottos.size) {
            println(doubleLottos[i])
        }
    }
    fun answerNumbersMessage(){
        println(ANSWER_NUMBERS_MESSAGE)
    }
}
