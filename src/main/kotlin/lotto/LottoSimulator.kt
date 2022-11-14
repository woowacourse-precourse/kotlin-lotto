package lotto

class LottoSimulator {

    companion object {
        private val moneyInputHandler = MoneyInputHandler()
        private val lottoNumberMaker = LottoNumberMaker()
        private val lottoAnswerNumberInputHandler = LottoAnswerNumberInputHandler()
        fun run() {
            try {
                val customer = initCustomer()
                val answer = lottoAnswerNumberInputHandler.getLottoAnswer()
                val bonusNumber = LottoBonusNumberInputHandler(answer).getBonusNumber()
                lottoNumberMaker.setLottoCount(customer.getCustomerMoney())
                customer.setSelectedLottoList(lottoNumberMaker.makeLottoList())
                val lotto = Lotto(answer)
                val lottoResult = lotto.checkLottoAnswer(customer.getSelectedLottoList(), bonusNumber)
                customer.setReward(RewardChecker(lottoResult).checkRank())
                val earningRateCalculator = EarningRateCalculator(customer.getReward(), customer.getCustomerMoney())
                customer.setEarningRatio(earningRateCalculator.calculateEarningRate())
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return
            }
        }

        private fun initCustomer(): Customer {
            val input = moneyInputHandler.getInputMoney().toInt()
            return Customer(input)
        }
    }
}