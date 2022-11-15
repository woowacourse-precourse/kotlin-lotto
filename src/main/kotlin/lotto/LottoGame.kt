package lotto

class LottoGame {
    fun calculateProfitRate() {

    }

    fun gameControl() {
        val lottoList = mutableListOf<Lotto>()

        val lottoQuantity = PurchaseLotto().issuedLotto(PurchaseLotto().purchase())

        PurchaseLotto().getLottoTicket(lottoList, lottoQuantity)

        val setWinningNumbers = GenerateWinningNumbers().inputWinningNumbers()
        val setBonusNumber = GenerateBonusNumber(setWinningNumbers).inputBonusNumber()

        for(issuedLotto in lottoList) {
            val checkLotto = MatchLotto().countLottoNumber(issuedLotto.getLottoNumbers(), setWinningNumbers, setBonusNumber)

            if(checkLotto == LottoRank.MATCH_THREE) LottoRank.MATCH_THREE.ticketCount++
            if(checkLotto == LottoRank.MATCH_FOUR) LottoRank.MATCH_FOUR.ticketCount++
            if(checkLotto == LottoRank.MATCH_FIVE) LottoRank.MATCH_FIVE.ticketCount++
            if(checkLotto == LottoRank.MATCH_FIVE_BONUS) LottoRank.MATCH_FIVE_BONUS.ticketCount++
            if(checkLotto == LottoRank.MATCH_SIX) LottoRank.MATCH_SIX.ticketCount++
        }

        printResult()

    }

    private fun printResult() {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${LottoRank.MATCH_THREE.ticketCount}개")
        println("4개 일치 (50,000원) - ${LottoRank.MATCH_FOUR.ticketCount}개")
        println("5개 일치 (1,500,000원) - ${LottoRank.MATCH_FIVE.ticketCount}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${LottoRank.MATCH_FIVE_BONUS.ticketCount}개")
        println("6개 일치 (2,000,000,000원) - ${LottoRank.MATCH_SIX.ticketCount}개")
    }

}