package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoPurchaser(val cost: Int) {
    init {
        require(cost >= Lotto.COST) { ERROR_COST_NOT_ENOUGH }
        require(cost % Lotto.COST == 0) { ERROR_COST_DIVIDE }
    }

    fun purchaseLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(cost / Lotto.COST) {
            lottos.add(generateLotto())
        }
        return lottos
    }

    private fun generateLotto() = Lotto(
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUM, Lotto.MAX_NUM, Lotto.LENGTH)
    )

    companion object {
        private const val ERROR_COST_NOT_ENOUGH = "구입금액은 ${Lotto.COST}원 이상이어야 합니다."
        private const val ERROR_COST_DIVIDE = "구입금액은 ${Lotto.COST}로 나누어 떨어져야 합니다."
    }
}
