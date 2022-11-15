package lotto

class Validator {
    /**
     * @param moneyString : String of money
     * @return Int type money if there was no exception case
     */
    fun validateMoney(moneyString: String): Int {
        if (!isNumber(moneyString)) throw IllegalArgumentException("$TAG 문자가 포함되지 않은 숫자를 입력하세요.")
        if (moneyString.toIntOrNull() == null || moneyString.toInt() < 1) throw IllegalArgumentException("$TAG 구입금액은 ${Int.MAX_VALUE}이하의 양의 정수여야 합니다.")
        if (moneyString.toInt() % LOTTERY_PRICE != 0) throw IllegalArgumentException("$TAG ${LOTTERY_PRICE}원 단위로 입력하세요.")
        return moneyString.toInt()
    }

    private fun isNumber(str: String): Boolean {
        for (c in str) {
            if (!c.isDigit()) {
                return false
            }
        }
        return true
    }
}