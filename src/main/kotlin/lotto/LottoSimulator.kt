package lotto

class LottoSimulator {
    companion object{

        fun run(){
            val moneyInputHandler = MoneyInputHandler()
            val input = moneyInputHandler.getInputMoney().toInt()
            val customer = Customer(input)
            val lottoNumberMaker = LottoNumberMaker()
            val lottoAnswerNumberInputHandler = LottoAnswerNumberInputHandler()
            val answer= lottoAnswerNumberInputHandler.getLottoAnswer()
            val bonusNumber =  LottoBonusNumberInputHandler(answer).getBonusNumber()
            lottoNumberMaker.setLottoCount(customer.getCustomerMoney())
            customer.setSelectedLottoList(lottoNumberMaker.makeLottoList())
            val lotto = Lotto(answer)
            val lottoResult =  lotto.checkLottoAnswer(customer.getSelectedLottoList(), bonusNumber)
            customer.setReward(RewardChecker(lottoResult).checkRank())
        }
    }
}