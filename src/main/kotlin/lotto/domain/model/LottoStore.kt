package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_LENGTH
import lotto.utils.Constants.MAX_LOTTO_NUM
import lotto.utils.Constants.MIN_LOTTO_NUM

class LottoStore : GenerateLottoNumber {

    override fun makeRandomNum(): List<Int> =
        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_LENGTH)
            .sorted()

    private fun generateLotto(): Lotto = Lotto(makeRandomNum().map {
        LottoNumber.valueOf(it)
    })

    fun purchaseLotto(money: Long): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat((money / Lotto.LOTTO_PRIZE).toInt()) {
            purchaseLottos.add(generateLotto())
        }
        return purchaseLottos.toList()
    }


}