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
        for(i in 0 until inputPrizeNumber.size){
            lottoWinningNumbers.add(inputPrizeNumber[i])
        }
        return inputPrizeNumber.map { it.toInt() }
    }

}