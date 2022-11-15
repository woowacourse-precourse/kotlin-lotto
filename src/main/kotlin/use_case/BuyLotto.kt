package use_case

import camp.nextstep.edu.missionutils.Randoms
import exception.LottoException
import lotto.Lotto
import kotlin.system.exitProcess

class BuyLotto {

    private var lottoSize = 0
    private var lottoList = mutableListOf<Lotto>()

    init {
        try {
            getTotalLottoPrice()
            createLottos()
        } catch (e: IllegalArgumentException){
            println("[ERROR] 로또 가격값 입력 오류")
            exitProcess(-1)
        }
    }

    fun getLottoList(): List<Lotto> {
        return lottoList
    }

    private fun getTotalLottoPrice() {
        println("구입금액을 입력해주세요.")
        lottoSize = readLine()?.toInt() ?: throw IllegalArgumentException()
        LottoException().priceException(lottoSize)
        lottoSize /= 1000
    }

    private fun createLottos() {
        println("\n${lottoSize}개를 구매했습니다.")
        for (i in 1..lottoSize){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            println(numbers)
            lottoList.add(Lotto(numbers))
        }
    }
}