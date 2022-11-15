package lotto.util

class Constant {
    companion object{
        val LOTTO_PRICE = 1000
        val LOTTO_SIZE = 6

        val REQUEST_MONEY = "구입금액을 입력해 주세요."

        val BUY_LOTTO = "개를 구매했습니다."
        val WINNING_LOTTO = "당첨 번호를 입력해 주세요."
        val BONUS_NUMBER = "보너스 번호를 입력해 주세요."

        val ERROR_INT_OR_NULL = "[ERROR] 구매 금액을 숫자 형태로 입력해야 합니다."
        val ERROR_THOUSAND = "[ERROR] 구매 금액을 1000원 단위로 입력하세요."
        val ERROR_SIX_LENGTH = "[ERROR] 6개의 숫자를 콤마로 구분하여 입력해주세요."
        val ERROR_NUMERIC = "[ERROR] 숫자 형태로 입력해주세요."
        val ERROR_1_45_RANGE = "[ERROR] 1~45 범위 내 숫자를 입력해주세요."
        val ERROR_ALREADY_IN = "[ERROR] 당첨 번호에 이미 존재하는 숫자입니다."

        val LOTTO_RESULT = "당첨 통계"
        val SEPERATOR = "- - -"
    }
}