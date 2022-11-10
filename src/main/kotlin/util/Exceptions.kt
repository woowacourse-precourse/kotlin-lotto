package util

object Exceptions {

    fun isValidInputMoney(money: String) {
        // 1000원으로 나누어 떨어져야함
        // 숫자만 들어가야한다
        val regex = "(^[1-9])([0-9]*)(0{3})(0*)".toRegex()
        if (!regex.matches(money)) {
            throw IllegalArgumentException(
                Messages.ERROR_MESSAGE +
                        Messages.ERROR_INVALID_INPUT_MESSAGE
            )
        }
    }

    // 로또번호가 중복되었는지 확인
    fun isValidLottoSize(lotto: List<Int>) {
        if (lotto.size != lotto.toSet().size) {
            throw IllegalArgumentException(
                Messages.ERROR_MESSAGE +
                        Messages.ERROR_LOTTO_NUMBER_DUPLICATE
            )
        }
    }
}