package lotto

import camp.nextstep.edu.missionutils.Randoms
import utils.Messages.ANSWER_NUMBERS_MESSAGE
import utils.Messages.BONUS_NUMBER_MESSAGE
import utils.Messages.BUY_PRICE_INQUIRE_MESSAGE
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_LOTTO_INPUT
import utils.Messages.BUY_AMOUNT_MESSAGE
import utils.Messages.ERROR_ANSWER_COMMA
import utils.Messages.ERROR_ANSWER_SIX
import utils.Messages.ERROR_BONUS_ONE
import utils.Messages.FIFTH_RANK_MESSAGE
import utils.Messages.FIRST_RANK_MESSAGE
import utils.Messages.FOURTH_RANK_MESSAGE
import utils.Messages.SECOND_RANK_MESSAGE
import utils.Messages.STATICS_COUNT_MESSAGE
import utils.Messages.STATICS_REVENUE_MESSAGE
import utils.Messages.STATICS_SPLITTER_MESSAGE
import utils.Messages.STATICS_TITLE_MESSAGE
import utils.Messages.THIRD_RANK_MESSAGE
import java.util.ListResourceBundle
import java.util.StringJoiner

class LottoGame {

    fun buyPriceInquireMessage() {
        println(BUY_PRICE_INQUIRE_MESSAGE)
    }

    fun inputNum(): Int {
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
        for (i in 0 until doubleLottos.size) {
            println(doubleLottos[i])
        }
    }
    fun answerNumbersMessage(){
        println(ANSWER_NUMBERS_MESSAGE)
    }

    fun inputAnswerNumbers(): MutableList<Int> {
        val inputAnswerNumbers = readLine().toString()
        val inputAnswerNumbersList = mutableListOf<Int>(6)

        if (!inputAnswerNumbers.contains(",")) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_ANSWER_COMMA)
        for (i in inputAnswerNumbers) {
            if(i.toString() != ","){
                inputAnswerNumbersList.add(i.code)
            }
        }
        inputAnswerNumbersList.removeAt(0)
        return inputAnswerNumbersList
    }

    fun bonusNumberMessage(){
        println(BONUS_NUMBER_MESSAGE)
    }

    fun checkinputBonus(inputBonus: String): Boolean {
        if (inputBonus.length != 1) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_BONUS_ONE)
        // 같은 숫자가 있는 지 체크하는 로직 추가
        return true
    }

    fun printStats(){
        val winList = mutableListOf<Int>()
        println(STATICS_TITLE_MESSAGE)
        println(STATICS_SPLITTER_MESSAGE)
        println(FIFTH_RANK_MESSAGE+winList[0]+STATICS_COUNT_MESSAGE)
        println(FOURTH_RANK_MESSAGE+winList[1]+ STATICS_COUNT_MESSAGE)
        println(THIRD_RANK_MESSAGE+winList[2]+ STATICS_COUNT_MESSAGE)
        println(SECOND_RANK_MESSAGE+winList[3]+ STATICS_COUNT_MESSAGE)
        println(FIRST_RANK_MESSAGE+winList[4]+ STATICS_COUNT_MESSAGE)
        println(STATICS_REVENUE_MESSAGE) // 여기에 수익률 수치 넣기
    }

    fun computeRank(doubleLottos: MutableList<List<Int>>) {
        val winList = mutableListOf<Int>()
        for (i in 0 until doubleLottos.size) {
            TODO()
        }
    }
}
