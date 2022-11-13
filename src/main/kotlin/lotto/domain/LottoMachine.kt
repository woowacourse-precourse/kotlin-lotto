package lotto.domain

class LottoMachine (cost: Int) {
    init {
        validateCostRange(cost)
    }

    private fun validateCostRange(cost: Int) {
        if (cost < 1000) {
            throw IllegalArgumentException(COST_RANGE_EXCEPTION)
        }
        if (cost % 1000 != 0) {
            throw IllegalArgumentException(COST_UNIT_EXCEPTION)
        }
    }

    companion object {
        const val COST_RANGE_EXCEPTION = "구매 불가능한 금액입니다. 1000원 이상부터 구매 가능합니다."
        const val COST_UNIT_EXCEPTION = "구매 불가능한 금액입니다. 1000원 단위로 구매 가능합니다."
    }
}