package lotto.util

import lotto.model.Reward

object Constant {

    const val REQUEST_MONEY = "구입금액을 입력해 주세요."
    const val BUY_COUNT = "개를 구매했습니다."
    const val REQUEST_WINNING_NUMBER= "당첨 번호를 입력해 주세요."
    const val REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    const val REWARD_RESULT = "당첨 통계"
    const val SEPARATOR = "---"

    const val THIRD = "3"
    const val FOURTH = "4"
    const val FIFTH = "5"
    const val FIFTH_BONUS = "5bonus"
    const val SIXTH = "6"
    const val MISS = "NONE"

    const val ERROR_NUMBER_FORMAT = "[ERROR] 숫자 형태로 입력해주세요."
    const val ERROR_THOUSAND = "[ERROR] 1000원 단위로 입력해주세요."
    const val ERROR_DISTINCT= "[ERROR] 중복되지 않는 숫자 6개를 콤마로 구분해 입력해주세요."
    const val ERROR_RANGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요."
    const val ERROR_IN_WINNING= "[ERROR] 당첨 번호에 없는 숫자를 입력해주세요."

    val RESULT = {reward: Reward, count: Int ->
        "${reward.match}개 일치 (${reward.prize}원) - ${count}개"
    }

    val BONUS_RESULT = {reward: Reward, count: Int ->
        val (match, bonus) = reward.match.split(" ")
        "${match}개 일치, ${bonus} 볼 일치 (${reward.prize}원) - ${count}개"
    }

    val PROFIT = { profit: Float -> "총 수익률은 ${profit}%입니다."}
}