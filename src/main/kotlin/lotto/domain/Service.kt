package lotto.domain

class Service {
    /**
     * 구입금액을 입력 받고 구매 갯수를 리턴하는 함수
     * */
    fun getPurchasingAmount(): Int {
        val inputPurchasingAmount = Util.readLine()
        ExceptionHandler.checkInputPurchasingAmount(inputPurchasingAmount)
        return (inputPurchasingAmount.toInt() / 1000)
    }

    /**
     * 구매 갯수 만큼 로또 번호를 생성해 리턴하는 함수
     * */
    fun getLottoNumbers(countOfLotto: Int): MutableList<List<Int>> {
        val lottoNumbers: MutableList<List<Int>> = mutableListOf()
        for (i in 0 until countOfLotto) {
            lottoNumbers.add(Util.createLottoNumbers().sorted())
        }
        return lottoNumbers
    }

    /**
     * 당첨 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getWinningNumbers(): List<Int> {
        val inputWinningNumber = Util.readLine()
        ExceptionHandler.checkInputWinningNumbers(inputWinningNumber)
        return inputWinningNumber.split(",").map { it.toInt() }
    }
}