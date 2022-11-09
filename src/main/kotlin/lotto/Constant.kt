package lotto

class Constant {
    companion object {
        const val lottoCost = 1000
        const val regularMin = '0'
        const val regularMax = '9'
        const val printBuyMessage = "개를 구매했습니다."
        const val costNotIntErrorMessage = "[ERROR] 1000으로 나누어 떨어지는 숫자를 입력해야 합니다."
        const val costNotRegularErrorMessage = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."
    }
}