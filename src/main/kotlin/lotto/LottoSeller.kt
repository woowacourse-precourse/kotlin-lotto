package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoSeller {

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
        println("당첨 번호를 입력해 주세요.")
        val inputPrizeNumber = Console.readLine().split(",")
        inputPrizeNumberException(inputPrizeNumber)
        for(i in 0 until inputPrizeNumber.size){
            lottoWinningNumbers.add(inputPrizeNumber[i])
        }
        return inputPrizeNumber.map { it.toInt() }
    }

    fun inputPrizeNumberException(inputPrizeNumber: List<String>) {
        val distinctPrizeNumber = inputPrizeNumber.distinct()
        if(distinctPrizeNumber.size != inputPrizeNumber.size) return throw IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.")
        if(inputPrizeNumber.size > 6) return throw IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개 보다 많습니다.")
    }

    fun inputBonusNumber(): Int {//보너스 번호 입력
        println("보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine()
        return inputBonusNumber.toInt()
    }



}