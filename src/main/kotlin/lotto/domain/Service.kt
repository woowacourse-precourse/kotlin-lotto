package lotto.domain

import lotto.domain.ExceptionHandler.checkInputBonusNumber
import lotto.domain.ExceptionHandler.checkInputPurchasingAmount
import lotto.domain.ExceptionHandler.checkInputWinningNumbers

class Service {
    /**
     * 구입금액을 입력 받고 구매 갯수를 리턴하는 함수
     * */
    fun getPurchasingAmount(): Int {
        val inputPurchasingAmount = Util.readLine()
        checkInputPurchasingAmount(inputPurchasingAmount)
        return (inputPurchasingAmount.toInt() / 1000)
    }

    /**
     * 구매 갯수 만큼 로또 번호를 생성해 리턴하는 함수
     * */
    fun getLottoNumbers(countOfLotto: Int): MutableList<Lotto> {
        val lottoNumbers: MutableList<Lotto> = mutableListOf()
        for (i in 0 until countOfLotto) {
            lottoNumbers.add(Lotto(Util.createLottoNumbers().sorted()))
        }
        return lottoNumbers
    }

    /**
     * 당첨 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getWinningNumbers(): Lotto {
        val inputWinningNumber = Util.readLine()
        checkInputWinningNumbers(inputWinningNumber)
        return Lotto(inputWinningNumber.split(",").map { it.toInt() })
    }
    /**
     * 보너스 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getBonusNumber(winningNumbers: List<Int>): Int {
        val inputBonusNumber = Util.readLine()
        checkInputBonusNumber(winningNumbers.map { it.toString() }, inputBonusNumber)
        return inputBonusNumber.toInt()
    }
}