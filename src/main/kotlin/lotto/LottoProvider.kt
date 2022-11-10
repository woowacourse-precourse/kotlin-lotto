package lotto

import lotto.util.requireWithPrefix

class LottoProvider {

    fun provideLottos(cost: Int): List<Lotto> {

        requireWithPrefix(cost > LOTTO_COST, "구입금액은 ${LOTTO_COST}이상이어야 합니다.")

        val lottos = mutableListOf<Lotto>()
        repeat(cost / LOTTO_COST) {
            lottos.add(Lotto.generate())
        }
        return lottos
    }
}