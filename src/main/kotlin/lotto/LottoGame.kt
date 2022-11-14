package lotto

class LottoGame {
    fun calculateProfitRate() {

    }

    fun gameControl() {
        val lottoList = mutableListOf<Lotto>()

        val lottoQuantity = PurchaseLotto().issuedLotto(PurchaseLotto().purchase())
        PurchaseLotto().getLottoTicket(lottoList, lottoQuantity)

        val testNum = GenerateWinningNumbers().inputWinningNumbers()
        val testBonus = GenerateBonusNumber(testNum).inputBonusNumber()
        val testWinningNumbers = testNum.getLottoNumbers().plus(testBonus)

        println(testWinningNumbers)
    }

}