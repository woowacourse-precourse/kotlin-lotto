package lotto.domain

import lotto.presentation.util.Constant.fifthRewardMoney
import lotto.presentation.util.Constant.firstRewardMoney
import lotto.presentation.util.Constant.fourthRewardMoney
import lotto.presentation.util.Constant.nothingRewardMoney
import lotto.presentation.util.Constant.secondRewardMoney
import lotto.presentation.util.Constant.thirdRewardMoney

enum class LottoReward(val cnt: Int, val prize: String) {
    FIRST(6, firstRewardMoney),
    SECOND(5, secondRewardMoney),
    THIRD(5, thirdRewardMoney),
    FOURTH(4, fourthRewardMoney),
    FIFTH(3, fifthRewardMoney),
    NOTHING(0, nothingRewardMoney)
}