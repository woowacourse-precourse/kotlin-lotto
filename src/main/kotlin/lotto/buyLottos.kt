package lotto

class buyLottos {

    fun sequences(){

        val userMainView = MainView()

        val boughtPrice = userMainView.getLottoPrice()
        val createLottos = boughtPrice?.let { CreateLottos.getLottoCount(it) }
        val boughtLottoNums = createLottos?.let { CreateLottos.getLottoNumsWithCount(it) }

        if (createLottos != null && boughtLottoNums != null) {
            userMainView.showLottoNums(createLottos, boughtLottoNums)
        }

        val winInput = userMainView.getWinNums()
        val winNums = winInput?.let { WinLotto.removeWinNumsComma(it) }

        val bonusInput = userMainView.getBonusNum()




    }

}