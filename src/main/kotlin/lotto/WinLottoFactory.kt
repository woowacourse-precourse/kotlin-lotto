package lotto

class WinLottoFactory {
    fun makeWinLotto(
        winLottoNumbers: List<Int>,
        winBonusNumber: Int,
    ): WinLotto {
        return WinLotto(
            ArrayList(winLottoNumbers).apply {
                add(winBonusNumber)
            }
        )
    }
}