package lotto

class Constant {
    companion object {
        const val lottoCost = 1000
        const val regularMin = '0'
        const val regularMax = '9'
        const val minLottoNumber = 1
        const val maxLottoNumber = 45
        const val lottoSize = 6
        const val firstReward = 2000000000
        const val secondReward = 30000000
        const val thirdReward = 1500000
        const val fourthReward = 50000
        const val fifthReward = 5000
        const val percent = 100

        const val inputAmountMessage = "구입금액을 입력해 주세요."
        const val inputWinningMessage = "\n당첨 번호를 입력해 주세요."
        const val inputBonusMessage = "\n보너스 번호를 입력해 주세요."
        const val printBuyMessage = "개를 구매했습니다."
        const val printRankMessage = "\n당첨 통계\n---"
        const val fifthRewardMessage = "3개 일치 (5,000원) - "
        const val fourthRewardMessage = "4개 일치 (50,000원) - "
        const val thirdRewardMessage = "5개 일치 (1,500,000원) - "
        const val secondRewardMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val firstRewardMessage = "6개 일치 (2,000,000,000원) - "
        const val count = "개"
        const val yieldMessage = "총 수익률은 "
        const val yieldEndMessage = "%입니다."

        const val emptyErrorMessage = "[ERROR] null이 아닌 숫자를 입력해야 합니다."
        const val notIntErrorMessage = "[ERROR] 문자가 아닌 숫자를 입력해야 합니다."
        const val costNotRegularErrorMessage = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."
        const val winningRegularErrorMessage = "[ERROR] ,로 구분해서 공백 없이 숫자 6개를 입력해주세요."
        const val winningRangeErrorMessage = "[ERROR] 1 ~ 45의 숫자만 입력해주세요."
        const val winningDigitErrorMessage = "[ERROR] 공백 없이 숫자로 입력해 주세요."
        const val winningDupleErrorMessage = "[ERROR] 중복 없이 입력해 주세요."
        const val bonusDupleErrorMessage = "[ERROR] 당첨 번호와 보너스는 중복 될 수 없습니다."

    }
}