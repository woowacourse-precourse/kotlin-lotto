package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto.Companion.COST
import lotto.domain.Lotto.Companion.LENGTH
import lotto.domain.Lotto.Companion.MAX_NUM
import lotto.domain.Lotto.Companion.MIN_NUM

class LottoPurchaser(val cost: Int) {
    init {
        require(cost >= COST) { ERROR_COST_NOT_ENOUGH }
        require(cost % COST == 0) { ERROR_COST_DIVIDE }
    }

    fun purchaseLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(cost / COST) {
            lottos.add(generateLotto())
        }
        return lottos
    }

    private fun generateLotto() = Lotto(
        Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LENGTH)
    )

    companion object {
        private const val ERROR_COST_NOT_ENOUGH = "구입금액은 ${COST}원 이상이어야 합니다."
        private const val ERROR_COST_DIVIDE = "구입금액은 ${COST}로 나누어 떨어져야 합니다."
    }
}
