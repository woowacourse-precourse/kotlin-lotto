package lotto

import lotto.util.readWinBonusNumber
import lotto.util.readWinLottoNumbers

/*
* 당첨 번호 입력 받기
* 보너스 번호 입력 받기
* 로또 비교
* 수익률 계산
* 결과 출력
* winLotto 가져오기
* */
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