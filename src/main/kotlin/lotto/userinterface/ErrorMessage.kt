package lotto.userinterface

private const val HEADER = "[ERROR] "
const val PURCHASE_AMOUNT_MUST_BE_A_NUMBER = HEADER + "로또 구입 금액은 숫자여야 합니다."
const val PURCHASE_AMOUNT_MUST_NOT_EXCEED_LIMIT = HEADER + "로또 구입 금액은 %s원을 초과할 수 없습니다."
const val PURCHASE_AMOUNT_MUST_BE_DIVIDED_BY_1000 = HEADER + "로또 구입 금액은 1000으로 나누어 떨어져야 합니다."
const val WINNING_NUMBERS_SIZE_MUST_BE_6 = HEADER + "당첨 번호는 6개여야 합니다."
const val WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45 = HEADER + "당첨 번호는 1에서 45 사이의 숫자여야 합니다."
const val WINNING_NUMBERS_MUST_NOT_BE_DUPLICATED = HEADER + "당첨 번호는 모두 서로 달라야 합니다."
const val BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45 = HEADER + "보너스 번호는 1에서 45 사이의 숫자여야 합니다."
const val BONUS_NUMBER_MUST_NOT_BE_INCLUDED_IN_WINNING_NUMBERS = HEADER + "보너스 번호는 당첨 번호에 포함되지 않아야 합니다."