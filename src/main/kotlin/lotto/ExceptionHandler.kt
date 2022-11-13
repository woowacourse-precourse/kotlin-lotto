package lotto

object ExceptionHandler {
    /**
     * 중복 여부 확인
     */
    fun isDuplicate(): Boolean {
        return true
    }

    /**
     * 길이가 6을 넘는지 확인
     */
    fun isOverLength() {

    }

    /**
     * 1~45사이 숫자인지 확인
     */
    fun isInRange() {

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

    fun isDivideBy1000(money: Int): Boolean {
        return (money % 1000) == 0
    }

    fun isOnlyInt(money: String): Boolean {
        for (i in money) {
            if (i.digitToIntOrNull() == null) {
                return false
            }
        }
        return true
    }
}