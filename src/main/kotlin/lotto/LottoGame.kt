package lotto

import camp.nextstep.edu.missionutils.Randoms
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_ANSWER_COMMA
import utils.Messages.ERROR_BONUS_ONE
import utils.Messages
import kotlin.NumberFormatException

class LottoGame {
    fun inputNum(): Int {
        val input = readLine()!!.trim()
        try {
            if (!checkRightLotto(input.toInt())) {
                println(Messages.ERROR_PREFIX_MESSAGE + Messages.ERROR_LOTTO_INPUT)
                return -1
            }
            if (input.length < 4) {
                println(Messages.ERROR_PREFIX_MESSAGE + Messages.ERROR_LOTTO_INPUT)
                return -1
            }
        } catch (e: NumberFormatException) {
            println(Messages.ERROR_PREFIX_MESSAGE + Messages.ERROR_LOTTO_INPUT)
            return -1
        }
        return input.toInt()
    }

    fun calculateNumberOfLotto(lottoInputPrice: Int): Int {
        return lottoInputPrice / 1000
    }

    fun checkRightLotto(lottoInputPrice: Int): Boolean {
        val numOfRestLotto = lottoInputPrice % 1000
        if (numOfRestLotto != 0) {
            return false
        }
        return true
    }

    fun generateRandomLottos(numOfLotto: Int): MutableList<List<Int>> {
        val lottos = mutableListOf<Int>()
        for (i in 1..numOfLotto) {
            val pickLottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.addAll(pickLottoNums)
        }
        val doubleLottos: MutableList<List<Int>> = lottos.chunked(6).toMutableList()
        return doubleLottos
    }

    fun inputAnswerNumbers(): MutableList<Int> {
        val inputAnswerNumbers = readLine()
        val inputAnswerNumbersList = mutableListOf<Int>()
        val inputAnswerNumbersSplit = inputAnswerNumbers!!.trim().split(",")
        if (!inputAnswerNumbers.contains(",")) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_ANSWER_COMMA)
        inputAnswerNumbersSplit.forEach() {
            inputAnswerNumbersList.add(it.toInt())
        }
        return inputAnswerNumbersList
    }

    fun checkinputBonus(inputBonus: String): Boolean {
        if (inputBonus.length != 1 && inputBonus.length != 2) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_BONUS_ONE)
        // 같은 숫자가 있는 지 체크하는 로직 추가
        return true
    }

    fun computeRank(
        doubleLottos: MutableList<List<Int>>,
        answerNumbers: MutableList<Int>,
        bonusNumber: Int
    ): MutableList<Int> {
        val countResultList = mutableListOf<MutableList<Int>>()
        val winList = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (i in 0 until doubleLottos.size) {
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
        bonusNumber: Int
    ): MutableList<Int> {
        val answerString = answerNumbers.toString()
        var countNormal = 0
        var countBonus = 0
        val countResultList = mutableListOf<Int>(0, 0)
        for (num in lottos) {
            if (answerString.contains(num.toString())) {
                countNormal += 1
            }
            if (answerString.contains(bonusNumber.toString()))
                countBonus += 1
        }
        countResultList[0] = countNormal
        countResultList[1] = countBonus
        return countResultList
    }

    fun statsRevenue(
        payCost: Int,
        winList: MutableList<Int>,
    ): Float {
        val revenue =
            5000 * winList[0] + 50000 * winList[1] + 1500000 * winList[2] + 30000000 * winList[3] + 2000000000 * winList[4]
        val roundRevenue = (revenue.toFloat() / payCost) * 100
        val result = String.format("%.2f", roundRevenue)
        return result.toFloat()
    }
}
