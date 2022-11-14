package exception

import lotto.LottoViewModel

class LottoBonus(bonusNumber: Int, winningNumber: String) {
    init {
        require(bonusNumber in 1..45) {
            "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        require(bonusNumber !in LottoViewModel.changeToIntList(winningNumber)) {
            "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
        }
    }
}