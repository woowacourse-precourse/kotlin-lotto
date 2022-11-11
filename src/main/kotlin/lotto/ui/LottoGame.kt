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
        println("구입금액을 입력해 주세요.")
        val cost = readInt()
        println()
        return cost
    }

    private fun purchaseLotto(cost: Int): List<Lotto> {
        return LottoPurchaser().purchaseLottos(cost)
    }

    private fun printLottoInfo(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        println()
    }

    private fun readWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val numbers = Console.readLine()
            .divideToNums(",")
        println()
        return numbers
    }

    private fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonus = readInt()
        println()
        return bonus
    }

    private fun printResultInfo(lottoResultInfo: LottoResultInfo) {
        val stats = lottoResultInfo.getStatInfo()
        val profit = lottoResultInfo.getProfitInfo()

        println("당첨 통계\n---")
        println(stats)
        println("총 수익률은 $profit%입니다.")
    }
}
