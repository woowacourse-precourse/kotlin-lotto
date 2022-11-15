package lotto.constants


const val INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
const val NUM_OF_LOTTO_MSG = "개를 구매했습니다."
const val INPUT_WIN_NUM_MSG = "당첨 번호를 입력해 주세요."
const val INPUT_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요."
const val WIN_RESULT_MSG = "당첨 통계\n" + "---"


fun earningRateMSG(rate: Double): String {
    if(rate>100){
        return "총 수익률은 ${rate.toLong()}%입니다."
    }

    return "총 수익률은 ${rate}%입니다."
}


const val INPUT_PURCHASE_AMOUNT_ERROR_MSG = "[ERROR] 로또 구입 금액은 1000원 단위의 숫자여야 합니다."
const val INPUT_WIN_NUM_SCOPE_ERROR_MSG = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
const val INPUT_BONUS_NUM_SCOPE_ERROR_MSG = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
const val INPUT_WIN_NUM_DUPLICATION_ERROR_MSG = "[ERROR] 당첨 번호가 중복되어 입력되었습니다."
const val INPUT_BONUS_NUM_DUPLICATION_ERROR_MSG="[ERROR] 보너스 번호는 로또 번호와 중복되어선 안됩니다."
const val INPUT_WIN_NUM_SIZE_ERROR_MSG = "[ERROR] 당첨 번호는 총 6개가 입력되어야 합니다."

const val MAKE_LOTTO_NUM_SCOPE_ERROR_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG = "[ERROR] 로또 번호가 중복되어 생성되었습니다."
const val MAKE_LOTTO_NUM_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 총 6개가 생성되어야 합니다."