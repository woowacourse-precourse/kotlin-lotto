package lotto.domain

import lotto.LOTTO_COST
import lotto.util.requireWithPrefix

class LottoPurchaser {
    fun purchaseLottos(cost: Int): List<Lotto> {
        requireWithPrefix(cost >= LOTTO_COST, ERROR_COST_NOT_ENOUGH)
        requireWithPrefix(cost % LOTTO_COST == 0, ERROR_COST_DIVIDE)

        val lottos = mutableListOf<Lotto>()
        repeat(cost / LOTTO_COST) {
            lottos.add(LottoFactory.generate())
        }
        return lottos
    }

    companion object {
        private const val ERROR_COST_NOT_ENOUGH = "구입금액은 ${LOTTO_COST}원 이상이어야 합니다."
        private const val ERROR_COST_DIVIDE = "구입금액은 ${LOTTO_COST}로 나누어 떨어져야 합니다."
    }
}
