package lotto.constants

class Exception {
    companion object {
        const val EXCEPTION_INVALID_MONEY = "[ERROR] 1,000원 단위로 나누어 떨어지는 금액을 입력해주세요."
        const val EXCEPTION_DUPLICATED_NUMBER = "[ERROR] 중복된 숫자가 있습니다."
        const val EXCEPTION_INVALID_COUNT = "[ERROR] 쉼표로 구분된 6개의 숫자를 입력해주세요."
        const val EXCEPTION_INVALID_CHARACTER = "[ERROR] 1 ~ 45 사이의 숫자만 입력해주세요."
    }
}