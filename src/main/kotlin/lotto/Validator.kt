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

    /**
     * @brief Validate lottery numbers
     * @param lotteryNumberList : List of lottery number(String)
     * @return List of lottery number(Int) if there is no exception case
     */
    fun validateLotteryNumber(lotteryNumberList: List<String>): List<Int> {
        if(lotteryNumberList.size != LOTTERY_SIZE) {
            throw IllegalArgumentException("$TAG ${LOTTERY_SIZE}개의 숫자를 입력하세요.")
        }
        val checkedList = mutableListOf<Int>()
        for(str in lotteryNumberList) {
            if(!isNumber(str)) throw IllegalArgumentException("$TAG 문자가 포함되지 않은 숫자를 입력하세요.")
            if(str.toIntOrNull() == null) throw IllegalArgumentException("$TAG 로또 번호는 ${NUMBER_RANGE.first}부터 ${NUMBER_RANGE.last} 사이의 숫자여야 합니다.")
            if(!NUMBER_RANGE.contains(str.toInt())) throw IllegalArgumentException("$TAG 로또 번호는 ${NUMBER_RANGE.first}부터 ${NUMBER_RANGE.last} 사이의 숫자여야 합니다.")
            if(checkedList.contains(str.toInt())) throw IllegalArgumentException("$TAG 로또 번호는 서로 다른 숫자로 구성되어야 합니다.")
            checkedList.add(str.toInt())
        }
        return checkedList
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