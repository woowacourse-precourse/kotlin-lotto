package lotto

class LottoStart(private val userMainView: MainView) {


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

        fun getWinningPrizeRanking(winList : List<Int>, earnRate : String){
            val lottoPrizeResult = LottoResult()
            lottoPrizeResult.getPrizeRanking(winList)
            userMainView.winTotal(lottoPrizeResult, earnRate)
        }

        fun getWinPrice(winList : List<Int>) : Int{
            var winningPrice = 0
            winList.forEach{
                winningPrice += it
            }
            return winningPrice
        }

        fun getEarningRate(boughtPrice : Int, winPrice : Int) : String{
            val earnRate = LottoResult().getEarningRate(boughtPrice, winPrice)
            return earnRate
        }


}