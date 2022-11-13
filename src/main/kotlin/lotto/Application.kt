package lotto

fun main() {
    val display = Display()
    val client = Client()
    val statistics = LottoStatistics()
    display.printRequirePurchaseAmount()

    client.inputPurchaseAmount()
    client.purchaseLotto()

    // 발행한 로또 수량 및 번호 출력
    display.printLottoCount(client.purchaseCount)
    display.printLottos(client.lottos)

    // 당첨 번호 및 보너스 번호 입력
    display.printRequireWinningNumbers()
    client.inputWinningNumbers(statistics)
    display.printRequireBonusNumber()
    client.inputBonusNumber(statistics)

    // 당첨 통계
    statistics.matchingCalculator(client)
    val matchingCounts = statistics.getMatchingCounts()
    val profit = statistics.getProfit()
    display.printStatistics(matchingCounts, profit)

}