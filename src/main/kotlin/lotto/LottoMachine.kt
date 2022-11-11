package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    fun start() {
        val paymentInput = View.getPaymentAmount()
        val numberOfLotto = getNumberOfLottos(paymentInput)

        val lottos: ArrayList<Lotto> = arrayListOf()
        repeat(numberOfLotto) {
            lottos.add(generateLotto())
        }
    }

    fun getNumberOfLottos(payment: String): Int {
        checkPaymentException(payment)
        return payment.toInt() / 1000
    }

    fun checkPaymentException(payment: String) {
        val price = payment.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        if (price % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원으로 나눠지지 않습니다.")
        }
    }

    fun generateLotto(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(randomNumbers)
    }

    fun checkWinningNumberException() {
        TODO()
    }

    fun checkBonusNumberException() {
        TODO()
    }

    fun calculateResult() {
        TODO()
    }

    fun calculateLottoResult() {
        TODO()
    }

    fun getEarningsRate(): Double {
        TODO()
    }

}