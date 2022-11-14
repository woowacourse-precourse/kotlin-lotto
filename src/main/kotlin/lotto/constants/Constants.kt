package lotto.constants


const val INPUT_PURCHASE_AMOUNT_MSG="구입금액을 입력해 주세요."
const val NUM_OF_LOTTO_MSG="개를 구매했습니다."
const val INPUT_WIN_NUM_MSG="당첨 번호를 입력해 주세요."
const val INPUT_BONUS_NUM_MSG="보너스 번호를 입력해 주세요."
const val WIN_RESULT_MSG="당첨 통계\n" + "---"

val WIN_CASE_MSG= listOf<String>(
    "3개 일치 (5,000원) - ",
    "4개 일치 (50,000원) - ",
    "5개 일치 (1,500,000원) - ",
    "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
    "6개 일치 (2,000,000,000원) - "
)
val WIN_CASE_MONEY=listOf<Long>(
    5000,
    50000,
    1500000,
    30000000,
    20000000000
)
fun earningRateMSG(rate:Double):String{
    return "총 수익률은 ${rate}%입니다."
}



const val INPUT_PURCHASE_AMOUNT_ERROR_MSG="[ERROR] 로또 구입 금액은 1000원 단위의 숫자여야 합니다."
const val INPUT_WIN_NUM_SCOPE_ERROR_MSG="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val INPUT_BONUS_NUM_ERROR_MSG="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
const val INPUT_WIN_NUM_SIZE_ERROR_MSG="[ERROR] 로또 번호는 총 6개가 입력되어야 합니다."
const val MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG="[ERROR] 로또 번호가 중복되어 생성되었습니다."
const val MAKE_LOTTO_NUM_SIZE_ERROR_MSG="[ERROR] 로또 번호는 총 6개가 생성되어야 합니다."