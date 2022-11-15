package lotto

class LottoStart(userMainView: MainView) {

    fun sequences(userMainView: MainView){


        fun createLottoNums() : List<List<Int>>?{
            val boughtPrice = userMainView.getLottoPrice()
            val createLottos = boughtPrice?.let { CreateLottos.getLottoCount(it) }
            val boughtLottoNums = createLottos?.let { CreateLottos.getLottoNumsWithCount(it) }

            if (createLottos != null && boughtLottoNums != null) {
                userMainView.showLottoNums(createLottos, boughtLottoNums)
            }
            return boughtLottoNums
        }

        fun getLottoWinNums() : List<Int>?{
            val winInput = userMainView.getWinNums()
            val winNums = winInput?.let { WinLotto.removeWinNumsComma(it) }
            if (winNums != null) {
                Lotto(winNums)
            }
            return winNums
        }

        fun getBonusNum() : Int?{
            val bonusInput = userMainView.getBonusNum()
            if (bonusInput != null) {
                Bonus(bonusInput)
            }
            return bonusInput
        }

        fun getWinningResult(boughtLottoNums : List<List<Int>>, winNums : List<Int>, bonusInput : Int) : List<Int>{
            val winList = SelectionWinning().getWinningListTotal(boughtLottoNums, winNums, bonusInput)
            return winList
        }

//        fun getWinningPrize(winList : List<Int>){
//            val lottoPrizeResult = LottoResult()
//            lottoPrizeResult.getPrizeRanking(winList)
//        }

        fun getWinPrice(winList : List<Int>) : Int{
            var winningPrice = 0
            winList.forEach{
                winningPrice += it
            }
            return winningPrice
        }

        val earningRate = LottoResult().getEarningRate(boughtPrice, )
        //earning rate 함수로 분리

    }

}