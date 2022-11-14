package lotto

object ExceptionHandler {
    fun checkLotto(lotto: Lotto): Boolean {
        if (isDuplicate(lotto.numberList)
                || isOverLength(lotto.numberList)
                || isInRange(lotto.numberList)) {
            return false
        }
        return true
    }

    fun checkNumberList(list: List<Int>): Boolean {
        if (isDuplicate(list)
                || isOverLength(list)
                || isInRange(list)) {
            return false
        }
        return true
    }

    private fun isDuplicate(list: List<Int>): Boolean {
        val distinctList = list.distinct()
        if (distinctList.size == 6) {
            return false
        }
        return true
    }

    private fun isOverLength(list: List<Int>): Boolean {
        if (list.size > 6) {
            return false
        }
        return true
    }

    private fun isInRange(list: List<Int>): Boolean {
        for (i in list) {
            if (i < 0 || i > 45) {
                return false
            }
        }
        return true
    }

    /**
     * 구입금액에 대한 예외 확인(숫자가 아니거나 1000원으로 나누어지지 않는 경우)
     */
    fun checkInputMoney(money: String): Boolean {
        if (isOnlyInt(money)) {
            if (isDivideBy1000(money.toInt())) {
                return true
            }
        }
        return false
    }

    private fun isDivideBy1000(money: Int): Boolean {
        return (money % 1000) == 0
    }

    private fun isOnlyInt(money: String): Boolean {
        for (i in money) {
            if (i.digitToIntOrNull() == null) {
                return false
            }
        }
        return true
    }
}