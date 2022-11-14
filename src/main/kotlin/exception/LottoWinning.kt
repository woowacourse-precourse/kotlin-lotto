package exception

import lotto.LottoViewModel

class LottoWinning(number: String) {
    private val winningNumberList = LottoViewModel.changeToIntList(number)
    var isBetween1And45 = true

    init {
        require(validateRange(winningNumberList)) {
            "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        require(winningNumberList.size == winningNumberList.distinct().count()) {
            "[ERROR] 당첨 번호에 중복된 숫자가 존재하지 않아야 합니다."
        }
        require(winningNumberList.size == 6) {
            "[ERROR] 당첨 번호는 6개여야 합니다."
        }
    }

    private fun validateElementRange(number: Int) {
        if (number < 1 || number > 45) {
            isBetween1And45 = false
        }
    }

    private fun validateRange(winningNumberList: List<Int>): Boolean {
        for (i in winningNumberList.indices) {
            validateElementRange(winningNumberList[i])
        }
        return isBetween1And45
    }
}