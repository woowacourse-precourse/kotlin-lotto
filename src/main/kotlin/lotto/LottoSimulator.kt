package lotto

class LottoSimulator {
    companion object{

        fun run(){
            val moneyInputHandler = MoneyInputHandler()
            val input = moneyInputHandler.getInputMoney().toInt()
            val customer = Customer(input)
            val lottoNumberMaker = LottoNumberMaker()
            val lottoAnswerNumberInputHandler = LottoAnswerNumberInputHandler()
            lottoNumberMaker.setLottoCount(customer.getCustomerMoney())
            customer.setSelectedLottoList(lottoNumberMaker.makeLottoList())
            val lotto = Lotto(lottoAnswerNumberInputHandler.getLottoAnswer())
        }
    }
}