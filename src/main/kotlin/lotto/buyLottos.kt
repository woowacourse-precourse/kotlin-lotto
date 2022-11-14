package lotto

//로또 사는 과정 전체를 시행할 클래스 UI 로직 함수를 포함한다.
class buyLottos {

    fun sequences(){

        val userMainView = MainView()

        val boughtPrice = userMainView.getLottoPrice()
        val createLottos = boughtPrice?.let { CreateLottos.getLottoCount(it) }

    }

}