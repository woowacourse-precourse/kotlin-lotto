package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val PRICE = 1000
class LottoLogic {

    private var userLotto = mutableListOf<Int>()
    private val userLottoList = mutableListOf<List<Int>>()
    private var userPurchaseAmount = ""
    private var lottoCount = 0

    fun lottoGenerator(): List<Int>{
        userLotto.clear()
        userLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        userLotto.sort()
        return userLotto
    }

    fun lottoPurchaseAmount(lottoCount: Int): Int {
        println(lottoCount % PRICE)
        if (lottoCount < PRICE) {
            throw IllegalArgumentException("[ERROR] 1,000원 이상을 입력하셔야 합니다.")
        } else if (lottoCount % PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 1,000원 단위를 입력하셔야 합니다.")
        }
        return lottoCount / PRICE
    }
}