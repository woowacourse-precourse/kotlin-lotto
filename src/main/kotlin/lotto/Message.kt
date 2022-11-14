package lotto

class Message {
    companion object {
        const val NOT_THOUSANDS_NUMBER = "[ERROR] 입력된 금액이 1000원단위여야 합니다."
        const val NOT_SIX_NUMBERS = "[ERROR] 입력된 수가 6자리가 아닙니다."
        const val DUPLICATED_NUMBERS = "[ERROR] 중복된 숫자가 있습니다."
        const val NOT_NUMBER = "[ERROR] 입력된 수가 로또번호가 아닙니다."

        const val BUY_LOTTO_MESSAGE = "개를 구매했습니다."
        const val INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요"
    }
}