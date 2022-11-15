package enterprise

import util.readWinBonusNumber
import util.readWinLottoNumbers
import winlotto.WinLotto
import winlotto.WinLottoFactory

class LottoEnterprise(
    private val winLottoFactory: WinLottoFactory,
) {
    fun getWinLotto(): WinLotto {
        val winLottoNumbers = getWinLottoNumbers()
        val winBonusNumber = getWinBonusNumber(winLottoNumbers)
        return winLottoFactory.makeWinLotto(
            winLottoNumbers,
            winBonusNumber
        )
    }

    private fun getWinLottoNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return readWinLottoNumbers()
    }

    private fun getWinBonusNumber(winLottoNumbers: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        return readWinBonusNumber(winLottoNumbers)
    }
}