package lotto.domain

import lotto.domain.InputExceptionHandler.checkInputBonusNumber
import lotto.domain.InputExceptionHandler.checkInputPurchasingAmount
import lotto.domain.InputExceptionHandler.checkInputWinningNumbers
import kotlin.math.round

class ApplicationService {
    companion object {
        const val PURCHASING_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입금액은 1000원 단위로 입력해야 합니다."
        const val WINNING_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 1 ~ 45 숫자 6개를 중복되지 않게 ,로 구분하여 입력해야 합니다."
        const val BONUS_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1 ~ 45 숫자 1개를 당첨 번호와 중복되지 않게 입력해야 합니다."
    }

    /**
     * 구입금액을 입력 받고 구매 갯수를 리턴하는 함수
     * */
    fun getPurchasingAmount(): Int {
        View.showInputPurchasingAmount()
        val inputPurchasingAmount = Util.readLine()
        return try {
            checkInputPurchasingAmount(inputPurchasingAmount)
            (inputPurchasingAmount.toInt() / 1000)
                .also {
                    View.showCountOfLotto(it)
                }
        } catch (e: IllegalArgumentException) {
            println(PURCHASING_AMOUNT_EXCEPTION_MESSAGE)
            0
        }
    }

    /**
     * 구매 갯수 만큼 로또 번호를 생성해 리턴하는 함수
     * */
    fun getLottoNumbers(countOfLotto: Int): MutableList<Lotto> {
        val lottoNumbers: MutableList<Lotto> = mutableListOf()
        for (i in 0 until countOfLotto) {
            lottoNumbers.add(Lotto(Util.createLottoNumbers().sorted()))
        }
        return lottoNumbers.also { View.showPurchasedLottoNumbers(it) }
    }

    /**
     * 당첨 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getWinningNumbers(): Lotto? {
        View.showInputWinningNumber()
        val inputWinningNumber = Util.readLine()
        return try {
            checkInputWinningNumbers(inputWinningNumber)
            Lotto(inputWinningNumber
                .split(",")
                .map { it.toInt() }).also { println(it.toString()) }
        } catch (e: IllegalArgumentException) {
            println(WINNING_NUMBERS_EXCEPTION_MESSAGE)
            null
        }
    }

    /**
     * 보너스 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getBonusNumber(winningNumbers: Lotto): Int {
        View.showInputBonusNumber()
        val inputBonusNumber = Util.readLine()
        return try {
            checkInputBonusNumber(winningNumbers, inputBonusNumber)
            inputBonusNumber.toInt().also { println(it) }
        } catch (e: IllegalArgumentException) {
            println(BONUS_NUMBER_EXCEPTION_MESSAGE)
            0
        }
    }
}