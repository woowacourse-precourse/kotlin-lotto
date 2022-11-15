package lotto

class LottoStart(userMainView: MainView) {

    fun sequences(userMainView: MainView){


        fun createLottoNum() : List<List<Int>>?{
            val boughtPrice = userMainView.getLottoPrice()
            val createLottos = boughtPrice?.let { CreateLottos.getLottoCount(it) }
            val boughtLottoNums = createLottos?.let { CreateLottos.getLottoNumsWithCount(it) }

            if (createLottos != null && boughtLottoNums != null) {
                userMainView.showLottoNums(createLottos, boughtLottoNums)
            }
            return boughtLottoNums
        }

        val winInput = userMainView.getWinNums()
        val winNums = winInput?.let { WinLotto.removeWinNumsComma(it) }
        if (winNums != null) {
            Lotto(winNums) //Lotto Class 를 리턴하는 getLottoWinNum 함수로 분리
        }

        val bonusInput = userMainView.getBonusNum()
        if (bonusInput != null) {
            Bonus(bonusInput) //Bonus Class를 리턴하는 getBonusNum 함수로 분리
        }

        val winList = SelectionWinning().getWinningListTotal(boughtLottoNums, winNums, bonusInput)
        //winning list를 만드는 함수로 분리

        val lottoPrizeResult = LottoResult()
        lottoPrizeResult.getPrizeRanking(winList)

        //winning prize 함수로 분리

        winningResultList.forEach{
            val winningPrice += it
        }

        val earningRate = LottoResult().getEarningRate(boughtPrice, )
        //earning rate 함수로 분리

    }

}