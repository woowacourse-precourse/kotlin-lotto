package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.LOTTO_COST
import lotto.LOTTO_LENGTH
import lotto.LOTTO_MAX_NUM
import lotto.LOTTO_MIN_NUM
import lotto.util.requireWithPrefix

class LottoPurchaser {
    fun purchaseLottos(cost: Int): List<Lotto> {
        requireWithPrefix(cost >= LOTTO_COST, ERROR_COST_NOT_ENOUGH)
        requireWithPrefix(cost % LOTTO_COST == 0, ERROR_COST_DIVIDE)

        val lottos = mutableListOf<Lotto>()
        repeat(cost / LOTTO_COST) {
            lottos.add(generateLotto())
        }
        return lottos
    }

    private fun generateLotto() = Lotto(
        Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
    )

    companion object {
        private const val ERROR_COST_NOT_ENOUGH = "구입금액은 ${LOTTO_COST}원 이상이어야 합니다."
        private const val ERROR_COST_DIVIDE = "구입금액은 ${LOTTO_COST}로 나누어 떨어져야 합니다."
    }
}
