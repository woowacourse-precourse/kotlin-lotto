package lotto

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val lottoMoney = Input.getLottoMoney()
        val lottoAmount = lottoMoney / 1000

        println("${lottoAmount}개를 구매했습니다.")
        val lottos = Lottos(lottoAmount)
        println(lottos.toString())

        println("당첨 번호를 입력해 주세요.")
        val winNumber = Input.getWinNumbers()

        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Input.getBonusNumber()

        println("당첨 통계\n---")
        val winRanks = lottos.calculateWinRanks(winNumber, bonusNumber)
        println(Statistics.formatWinRanks(winRanks))

        val yieldPercentage = lottos.calculateYield(winRanks, lottoAmount)
        println(Statistics.formatYield(yieldPercentage))
    } catch (e: IllegalArgumentException) {
        println("[ERROR] " + e.message)
    }
}
