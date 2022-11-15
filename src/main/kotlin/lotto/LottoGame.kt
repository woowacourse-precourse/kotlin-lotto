package lotto

class LottoGame {
    private val display = Display()
    private val client = Client()
    private val statistics = LottoStatistics()
    fun start() {
        display.printRequirePurchaseAmount()

        val purchaseAmount = client.inputPurchaseAmount()
        val purchaseLottos = client.purchaseLotto()
        if(purchaseAmount < 0)
            return

        // 발행한 로또 수량 및 번호 출력
        display.printLottoCount(purchaseAmount)
        display.printLottos(purchaseLottos)

        // 당첨 번호 및 보너스 번호 입력
        winningNumbersNBonus()

        // 당첨 통계
        val matchingResult = statistics.matchingCalculator(purchaseAmount, purchaseLottos)
        display.printStatistics(matchingResult)
    }


    private fun winningNumbersNBonus() {
        display.printRequireWinningNumbers()
        client.inputWinningNumbers(statistics)

        display.printRequireBonusNumber()
        client.inputBonusNumber(statistics)
    }
}