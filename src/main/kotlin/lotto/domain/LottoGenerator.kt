package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

import util.Constants
import util.Exceptions

/**
 * - [로또 구입 금액을 받는 클래스]
 * 금액에 따라 랜덤한 로또들을 발행하여 리스트로 반환
 */
class LottoGenerator(private val money: String) {
    // 구입할 로또들의 수
    private var buys = 0

    init {
        // 로또 금액에 대한 예외 사항 확인
        Exceptions.isValidInputMoney(money)
        calculateMoneyToBuys()
    }

    // 금액에 맞게 로또 발행
    fun getLottoList(): List<Lotto> {
        val lotteries = mutableListOf<Lotto>().apply {
            repeat(buys) { add(Lotto(randomLottoNumbers())) }
        }.toList()
        return lotteries
    }

    // 랜덤한 로또 번호 생성
    private fun randomLottoNumbers() =
         Randoms.pickUniqueNumbersInRange(Constants.RANGE_START, Constants.RANGE_END, Constants.MAX_SIZE)

    private fun calculateMoneyToBuys() {
        buys = money.toInt() / Constants.LOTTO_PRICE
    }

}