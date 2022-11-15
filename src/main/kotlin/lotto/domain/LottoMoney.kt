package lotto.domain

class LottoMoney(private val inputMoney: Int) {

    init {
        isValidMoneyAmount(inputMoney)
    }

    private fun isValidMoneyAmount(inputMoney: Int) {
        if (inputMoney % PRICE_PER_LOTTO != 0 || inputMoney == 0) {
            throw IllegalArgumentException("[ERROR]: 1,000원 단위의 숫자로만 입력되어야 합니다.")
        }
    }

    fun getPurchaseLottoAmount(): Int {
        return inputMoney / PRICE_PER_LOTTO
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
    }
}