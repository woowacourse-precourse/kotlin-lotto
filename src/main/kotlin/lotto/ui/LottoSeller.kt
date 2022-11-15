package lotto.ui

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto

class LottoSeller {

    fun chkNum(str: String) : Boolean {
        var temp: Char
        var result = false
        for (i in 0 until str.length) {
            temp = str.elementAt(i)
            if (temp.toInt() < 48 || temp.toInt() > 57) {
                result = true
            }
        }
        return result
    }

    fun calLottoCount(inputPrice: Int): List<Lotto> {//로또 개수
        val amountLotto = lottoCount(inputPrice)
        return lottoNumbers(amountLotto)
    }

    fun lottoCount(inputPrice: Int): Int {
        val lottoCnt = (inputPrice / 1000)
        println("\n${lottoCnt}개를 구매했습니다.")
        return lottoCnt
    }

    fun lottoNumbers(lottoCount : Int) : List<Lotto> {//로또 수량 및 번호 발행
        var saveLottoNumbers = ArrayList<Lotto>()
        for(i in 0 until lottoCount) {
            val randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(randomLottoNumbers.sorted())
            saveLottoNumbers.add(Lotto(randomLottoNumbers))
        }
        return saveLottoNumbers
    }

    fun inputPrizeNumber(lottoWinningNumbers: ArrayList<String>): List<Int> {
        println(ConstMessage.ENTER_WIN_NUMBER)
        val inputPrizeNumber = Console.readLine().split(",")
        inputPrizeNumberException(inputPrizeNumber)
        for(i in 0 until inputPrizeNumber.size){
            lottoWinningNumbers.add(inputPrizeNumber[i])
        }
        return inputPrizeNumber.map { it.toInt() }
    }

    fun inputPrizeNumberException(inputPrizeNumber: List<String>) {
        val distinctPrizeNumber = inputPrizeNumber.distinct()
        if(distinctPrizeNumber.size != inputPrizeNumber.size) throw IllegalArgumentException(ConstMessage.ENTER_DUPLICATION_NUMBER_EXCEPTION)
        if(inputPrizeNumber.size > 6) throw IllegalArgumentException(ConstMessage.ENTER_MORE_NUMBER_EXCEPTION)
    }

    fun inputBonusNumber(): Int {//보너스 번호 입력
        println(ConstMessage.ENTER_BONUS_NUMBER)
        val inputBonusNumber = Console.readLine()
        inputBonusNumberException(inputBonusNumber.toInt())
        return inputBonusNumber.toInt()
    }

    fun inputBonusNumberException(inputBonusNumber: Int) {
        when {
            inputBonusNumber < 1 -> return throw IllegalArgumentException(ConstMessage.OUT_OF_RANGE_EXCEPTION)
            inputBonusNumber > 45 -> return throw IllegalArgumentException(ConstMessage.OUT_OF_RANGE_EXCEPTION)
            chkNum(inputBonusNumber.toString()) -> return throw IllegalArgumentException(ConstMessage.NON_NUMBER_EXCEPTION)
        }
    }

}