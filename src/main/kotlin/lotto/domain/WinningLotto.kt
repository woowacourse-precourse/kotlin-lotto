package lotto.domain

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Int) {

    init {
        isValidBonusNumber()
    }

    private fun isValidBonusNumber() {
        val lottoNumList = winningLotto.getLottoNumberList()
        if (lottoNumList.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR]: 당첨 번호와 보너스 번호는 중복될 수 없다.")
        }
    }
}