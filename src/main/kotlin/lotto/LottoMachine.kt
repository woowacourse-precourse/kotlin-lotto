package lotto

class LottoMachine(lottoAmount: String) {
    init {
        validateTypeAmount(lottoAmount)
        validateUnitAmount(lottoAmount)
    }

    fun validateTypeAmount(amount: String): Boolean {
        val typeCount = amount.filter { number ->
            number in '0'..'9'
        }
        return when (typeCount.length) {
            amount.length -> true
            else -> throw IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력해주세요.")
        }
    }

    fun validateUnitAmount(amount: String): Boolean {
        return when (amount.toInt() % 1000) {
            0 -> true
            else -> throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요")
        }
    }
}