package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.LottoPurchaser
import lotto.domain.LottoResult
import lotto.domain.WinningNumber
import lotto.util.divideToNums
import lotto.util.readInt

class LottoGame {
    fun start() {
        val originCost = readCost()
        val lottos = purchase(originCost)

        val winningNumber = WinningNumber(
            readWinningNumber(),
            readBonusNumber()
        )
        val lottoResult = LottoResult(lottos, winningNumber, originCost)
        val lottoResultInfo = LottoResultInfo(lottoResult)

        printResultInfo(lottoResultInfo)
    }

    private fun readCost(): Int {
        println("구입금액을 입력해 주세요.")
        return readInt()
    }

    private fun purchase(cost: Int): List<Lotto> {
        val lottos = LottoPurchaser().purchaseLottos(cost)
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        return lottos
    }

    private fun readWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return Console
            .readLine()
            .divideToNums(",")
    }

    private fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return readInt()
    }

    private fun printResultInfo(lottoResultInfo: LottoResultInfo) {
        println("당첨 통계\n---")
        println(lottoResultInfo.getStatInfo())
        println("총 수익률은 ${lottoResultInfo.getProfitInfo()}%입니다.")
    }
}
