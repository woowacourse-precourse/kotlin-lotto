package lotto.enum

import java.text.DecimalFormat

enum class LottoGameString(val string: String) {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."){
        fun print() = println(string)
    },
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."){
        fun print() = println(string)
    },
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."){
        fun print() = println(string)
    },
    WINNING_FIFTH("3개 일치 (${LottoReward.FIFTH_REWARD.rewardString()}원) - "){
        fun print(number: Int) = println("$string${number}개")
    },
    WINNING_FOURTH("4개 일치 (${LottoReward.FOURTH_REWARD.rewardString()}원) - "){
        fun print(number: Int) = println("$string${number}개")
    },
    WINNING_THIRD("5개 일치 (${LottoReward.THIRD_REWARD.rewardString()}원) - "){
        fun print(number: Int) = println("$string${number}개")
    },
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (${LottoReward.SECOND_REWARD.rewardString()}원) - "){
        fun print(number: Int) = println("$string${number}개")
    },
    WINNING_FIRST("6개 일치 (${LottoReward.FIRST_REWARD.rewardString()}원) - "){
        fun print(number: Int) = println("$string${number}개")
    },
    EARNINGS_RATE(""){
        fun print(earningsRate: Int) = println("총 수익률은 $earningsRate%입니다.")
    }
}