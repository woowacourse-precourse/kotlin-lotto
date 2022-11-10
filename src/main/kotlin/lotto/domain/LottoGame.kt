package lotto.domain

import camp.nextstep.edu.missionutils.Console
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

        val lottoResult = LottoResult(lottos, winningNumber)
        printResult(lottoResult, originCost)
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
        return Console.readLine()
            .divideToNums(",")
    }

    private fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return readInt()
    }

    private fun printResult(lottoResult: LottoResult, origin: Int) {
        println("당첨 통계\n---")
        println(lottoResult)
        val profit = lottoResult.computeProfit(origin)
        println("총 수익률은 ${profit}입니다.")
    }
}