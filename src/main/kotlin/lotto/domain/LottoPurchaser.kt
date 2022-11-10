package lotto.domain

import lotto.LOTTO_COST
import lotto.util.requireWithPrefix

class LottoPurchaser {

    fun purchaseLottos(cost: Int): List<Lotto> {

        requireWithPrefix(cost >= LOTTO_COST, "구입금액은 ${LOTTO_COST}원 이상이어야 합니다.")
        requireWithPrefix(cost % LOTTO_COST == 0, "구입금액은 ${LOTTO_COST}로 나누어 떨어져야 합니다.")

        val lottos = mutableListOf<Lotto>()
        repeat(cost / LOTTO_COST) {
            lottos.add(LottoFactory.generate())
        }
        return lottos
    }
}