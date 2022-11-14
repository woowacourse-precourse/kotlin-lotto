package lotto

class buyLottos {

    fun sequences(){

        val userMainView = MainView()

        val boughtPrice = userMainView.getLottoPrice()
        val createLottos = boughtPrice?.let { CreateLottos.getLottoCount(it) }

    }

}