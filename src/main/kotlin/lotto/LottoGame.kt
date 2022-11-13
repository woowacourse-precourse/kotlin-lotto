package lotto

import camp.nextstep.edu.missionutils.Randoms
import utils.Messages.ANSWER_NUMBERS_MESSAGE
import utils.Messages.BONUS_NUMBER_MESSAGE
import utils.Messages.BUY_PRICE_INQUIRE_MESSAGE
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_LOTTO_INPUT
import utils.Messages.BUY_AMOUNT_MESSAGE
import utils.Messages.ERROR_ANSWER_COMMA
import utils.Messages.ERROR_BONUS_ONE
import utils.Messages.STATICS_SPLITTER_MESSAGE
import utils.Messages.STATICS_TITLE_MESSAGE
import lotto.Ranking.Rank
import utils.Messages.STATICS_REVENUE_PREFIX_MESSAGE
import utils.Messages.STATICS_REVENUE_SUFFIX_MESSAGE
import java.lang.Math.round

class LottoGame {

    fun buyPriceInquireMessage() {
        println(BUY_PRICE_INQUIRE_MESSAGE)
    }

    fun inputNum(): Int {
        val input = readLine()
        for (i in input.toString()) {
            if("[a-z]||[A-Z]".toRegex().matches(i.toString())){
                println(i)
                throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_LOTTO_INPUT)
            }
        }
        return input!!.toInt()
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
        for (i in 1..numOfLotto){
            val pickLottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.addAll(pickLottoNums)
        }
        var doubleLottos: MutableList<List<Int>> = lottos.chunked(6).toMutableList()
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
                inputAnswerNumbersList.add((i.code) - 48)
            }
        }
        inputAnswerNumbersList.removeAt(0)
        return inputAnswerNumbersList
    }

    fun bonusNumberMessage(){
        println(BONUS_NUMBER_MESSAGE)
    }

    fun checkinputBonus(inputBonus: String): Boolean {
        if (inputBonus.length != 1 && inputBonus.length != 2) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_BONUS_ONE)
        // 같은 숫자가 있는 지 체크하는 로직 추가
        return true
    }

    fun printStatsRank(winList: MutableList<Int>){
        println(STATICS_TITLE_MESSAGE)
        println(STATICS_SPLITTER_MESSAGE)
        Rank.FIFTH.print(winList)
        Rank.FOURTH.print(winList)
        Rank.THIRD.print(winList)
        Rank.SECOND.print(winList)
        Rank.FIRST.print(winList)
    }
    fun computeRank(
        doubleLottos: MutableList<List<Int>>,
        answerNumbers: MutableList<Int>,
        bonusNumber: Int): MutableList<Int> {
        val countResultList = mutableListOf<MutableList<Int>>()
        val winList = mutableListOf<Int>(0,0,0,0,0)
        for (i in 0 until doubleLottos.size){
//            countResultList[i] = countSameNumbers(doubleLottos[i], answerNumbers, bonusNumber)) // 근데 이건 왜 안되지?
            countResultList.add(i, countSameNumbers(doubleLottos[i], answerNumbers, bonusNumber))
        }
        for (i in 0 until countResultList.size) {
            when {
                countResultList[i][0] == 3 -> winList[0] += 1
                countResultList[i][0] == 4 -> winList[1] += 1
                countResultList[i][0] == 5 -> winList[2] += 1
                countResultList[i][0] == 5 && countResultList[i][1] == 1 -> winList[3] += 1
                countResultList[i][0] == 6 -> winList[4] += 1
            }
        }
        return winList
    }

    fun countSameNumbers(
        lottos: List<Int>,
        answerNumbers: MutableList<Int>,
        bonusNumber: Int): MutableList<Int> {
        val answerString = answerNumbers.toString()
        var countNormal = 0
        var countBonus = 0
        var countResultList = mutableListOf<Int>(0,0)
        for (num in lottos) {
            if (answerString.contains(num.toString())){
                countNormal += 1
            }
            if (answerString.contains(bonusNumber.toString()))
                countBonus += 1
        }
        countResultList[0] = countNormal
        countResultList[1] = countBonus
        return countResultList
    }

    fun printStatsRevenue(revenuePercent: Float){
        println(STATICS_REVENUE_PREFIX_MESSAGE+"$revenuePercent"+ STATICS_REVENUE_SUFFIX_MESSAGE) // 여기에 수익률 수치 넣기
    }
    fun statsRevenue(payCost: Int,
                 winList: MutableList<Int>,
                 ): Float {
    val revenue = 5000 * winList[0] + 50000 * winList[1] + 1500000 * winList[2] + 30000000 * winList[3] + 2000000000 * winList[4]
    val roundRevenue = (revenue.toFloat() / payCost) * 100
    val result = String.format("%.2f", roundRevenue)
    return result.toFloat()
    }
}
