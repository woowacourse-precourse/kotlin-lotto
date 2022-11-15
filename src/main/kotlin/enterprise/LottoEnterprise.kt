package enterprise

import util.readWinBonusNumber
import util.readWinLottoNumbers
import view.EnterpriseUI
import winlotto.WinLotto
import winlotto.WinLottoFactory


const val LOTTO_NUM_COUNT = 6
const val LOTTO_BONUS_NUM_COUNT = 1
const val LOTTO_PRICE = 1_000
const val LOTTO_NUM_RANGE_START = 1
const val LOTTO_NUM_RANGE_END = 45
const val LOTTO_MAX_GRADE = 5
const val LOTTO_MIN_GRADE = 1


val lottoPrize = longArrayOf(
    0,
    2_000_000_000,
    30_000_000,
    1_500_000,
    50_000,
    5_000
)

data class SameLottoResult(
    val lottoSameCount: Int,
    val isBonusSame: Boolean,
) {
    fun parseSameResultToGrade(): Int = when (this.lottoSameCount) {
        3 -> 5
        4 -> 4
        5 -> {
            if (this.isBonusSame) 2
            else 3
        }
        6 -> 1
        else -> 0
    }
}

class LottoEnterprise(
    private val winLottoFactory: WinLottoFactory,
    private val enterpriseUI: EnterpriseUI,
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
        enterpriseUI.showUI(EnterpriseUI.Companion.UI.ASK_WIN_LOTTO_NUMBERS_INPUT)
        return readWinLottoNumbers()
    }

    private fun getWinBonusNumber(winLottoNumbers: List<Int>): Int {
        enterpriseUI.showUI(EnterpriseUI.Companion.UI.ASK_WIN_LOTTO_BONUS_NUMBER_INPUT)
        return readWinBonusNumber(winLottoNumbers)
    }
}