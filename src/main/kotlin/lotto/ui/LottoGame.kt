package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoPurchaser
import lotto.domain.LottoResult
import lotto.domain.WinningNumber

class LottoGame {

    private val inputReader = InputReader()

    fun start() {
        try {
            startUtil()
        } catch (e: IllegalArgumentException) {
            println("$ERROR_MSG_PREFIX ${e.message}")
        }
    }

    private fun startUtil() {
        val originCost = readCost()
        val lottos = LottoPurchaser(originCost)
            .purchaseLottos()
        printLottoInfo(lottos)

        val winningNumber = WinningNumber(
            readWinLotto(),
            readBonusNumber()
        )
        val lottoResult = LottoResult(lottos, winningNumber, originCost)
        val lottoResultFormatter = LottoResultFormatter(lottoResult)

        printResultInfo(lottoResultFormatter)
    }

    private fun readCost(): Int {
        println(REQUEST_MONEY)
        return inputReader.readNumber()
    }

    private fun printLottoInfo(lottos: List<Lotto>) {
        println(LOTTO_SIZE_FORMAT.format(lottos.size))
        lottos.forEach { println(it.toString()) }
        println()
    }

    private fun readWinLotto(): Lotto {
        println(REQUEST_WINNING_NUMBER)
        val winNumbers = inputReader.readNumbers()
        return Lotto(winNumbers)
    }

    private fun readBonusNumber(): Int {
        println(REQUEST_BONUS)
        return inputReader.readNumber()
    }

    private fun printResultInfo(lottoResultFormatter: LottoResultFormatter) {
        val stats: String = lottoResultFormatter.getStatInfo()
        val profit: String = lottoResultFormatter.getProfitInfo()
        println(RESULT_INFO_FORMAT.trimIndent().format(stats, profit))
    }

    companion object {
        private const val ERROR_MSG_PREFIX = "[ERROR]"
        private const val REQUEST_MONEY = "구입금액을 입력해 주세요."
        private const val LOTTO_SIZE_FORMAT = "%d개를 구매했습니다."
        private const val REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS = "보너스 번호를 입력해 주세요."
        private const val RESULT_INFO_FORMAT =
            """
                당첨 통계
                ---
                %s
                %s
            """
    }
}
