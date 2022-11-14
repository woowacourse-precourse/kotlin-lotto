package lotto

class LottoSimulator {
    companion object{

        fun run(){
            val moneyInputHandler = MoneyInputHandler()
            val input = moneyInputHandler.getInputMoney().toInt()
            val customer = Customer(input)
            val lottoNumberMaker = LottoNumberMaker()
            lottoNumberMaker.setLottoCount(customer.getCustomerMoney())
            customer.setSelectedLottoList(lottoNumberMaker.makeLottoList())

        }
    }
}