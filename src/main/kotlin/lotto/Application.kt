package lotto

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val lottoMoney = Input.getLottoMoney()

        println("${lottoMoney}개를 구매했습니다.")
        val lottos = Lottos(lottoMoney)
        println(lottos.toString())

        println("당첨 번호를 입력해 주세요.")
        val winNumber = Input.getWinNumbers()

        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Input.getBonusNumber()

        println("당첨 통계\n---")
        val winRanks = lottos.calculateWinRanks(winNumber, bonusNumber)
        println(Statistics.formatWinRanks(winRanks))

        val yieldPercentage = lottos.calculateYield(winRanks, lottoMoney)
        println(Statistics.formatYield(yieldPercentage))
    } catch (e: IllegalArgumentException) {
        println("[ERROR] " + e.message)
    }
}
