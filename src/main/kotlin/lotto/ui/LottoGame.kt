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
        val lottos = purchaseLotto(originCost)

        printLottoInfo(lottos)

        val winningNumber = WinningNumber(
            readWinningNumber(),
            readBonusNumber()
        )
        val lottoResult = LottoResult(lottos, winningNumber, originCost)
        val lottoResultInfo = LottoResultInfo(lottoResult)

        printResultInfo(lottoResultInfo)
    }

    private fun readCost(): Int {
        println(REQUEST_MONEY)
        val cost = readInt()
        println()
        return cost
    }

    private fun purchaseLotto(cost: Int): List<Lotto> {
        return LottoPurchaser().purchaseLottos(cost)
    }

    private fun printLottoInfo(lottos: List<Lotto>) {
        println(LOTTO_INFO_FORMAT.format(lottos.size))
        lottos.forEach { println(it.toString()) }
        println()
    }

    private fun readWinningNumber(): List<Int> {
        println(REQUEST_WINNING_NUMBER)
        val numbers = Console.readLine()
            .divideToNums(",")
        println()
        return numbers
    }

    private fun readBonusNumber(): Int {
        println(REQUEST_BONUS)
        val bonus = readInt()
        println()
        return bonus
    }

    private fun printResultInfo(lottoResultInfo: LottoResultInfo) {
        val stats: String = lottoResultInfo.getStatInfo()
        val profit: String = lottoResultInfo.getProfitInfo()
        println(RESULT_INFO_FORMAT.trimIndent().format(stats, profit))
    }

    companion object {
        private const val REQUEST_MONEY = "구입금액을 입력해 주세요."
        private const val LOTTO_INFO_FORMAT = "%d개를 구매했습니다."
        private const val REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS = "보너스 번호를 입력해 주세요."
        private const val RESULT_INFO_FORMAT =
            """
                당첨 통계
                ---
                %s
                총 수익률은 %s입니다.
            """
    }
}
