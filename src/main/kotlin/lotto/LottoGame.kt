package lotto

import camp.nextstep.edu.missionutils.Randoms
import utils.Messages.BUY_PRICE_INQUIRE_MESSAGE
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_LOTTO_INPUT
import utils.Messages.BUY_AMOUNT_MESSAGE
import java.util.Arrays

class LottoGame {

    fun buyPriceInquireMessage() {
        println(BUY_PRICE_INQUIRE_MESSAGE)
    }

//    fun calculateNumberOfLotto(): Int {
//        val lottoInputPrice = readLine()!!.toInt()
//        return lottoInputPrice / 1000
//    }
//
//    fun checkRightLotto(lottoInputPrice: Int ): Boolean {
//        val numOfRestLotto = lottoInputPrice % 1000
//        if (numOfRestLotto != 0) {
//            return false
//        }
//        return true
//    }
//
//    fun resultRightLotto (flag: Boolean) {
//        if (!flag) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_LOTTO_INPUT)
//    }
//
//    fun tellNumOfLotto(numOfLotto: Int) {
//        println("$numOfLotto"+BUY_AMOUNT_MESSAGE)
//    }
//
//    fun generateRandomLottos(numOfLotto: Int): MutableList<Int> {
//        val lottos = mutableListOf<Int>()
//        for (i in 0..numOfLotto){
//            val pickLottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
//            lottos.addAll(pickLottoNums)
//        }
//        return lottos
//    }
}
