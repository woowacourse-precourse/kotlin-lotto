package lotto.domain

import lotto.domain.InputExceptionHandler.checkInputBonusNumber
import lotto.domain.InputExceptionHandler.checkInputPurchasingAmount
import lotto.domain.InputExceptionHandler.checkInputWinningNumbers
import kotlin.math.round

class Service {
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
        } catch (e: IllegalArgumentException) {
            println(PURCHASING_AMOUNT_EXCEPTION_MESSAGE)
            0
        }
    }

    /**
     * 구매 갯수 만큼 로또 번호를 생성해 리턴하는 함수
     * */
    fun getLottoNumbers(countOfLotto: Int): MutableList<Lotto> {
        View.showCountOfLotto(countOfLotto)
        val lottoNumbers: MutableList<Lotto> = mutableListOf()
        for (i in 0 until countOfLotto) {
            lottoNumbers.add(Lotto(Util.createLottoNumbers().sorted()))
        }
        return lottoNumbers.also { View.showPurchasedLottoNumbers(lottoNumbers) }
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
                .map { it.toInt() })
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
            inputBonusNumber.toInt()
        } catch (e: IllegalArgumentException) {
            println(BONUS_NUMBER_EXCEPTION_MESSAGE)
            0
        }
    }

    /**
     * 당첨 여부 정보를 리턴하는 함수
     * */
    fun isWinningLotto(lottoNumbers: MutableList<Lotto>, winningNumbers: Lotto, bonusNumber: Int): MutableList<Rating> {
        val ranks: MutableList<Rating> = mutableListOf()
        for (lottoNumber in lottoNumbers) {
            val (hit, bonus) = compareNumbers(lottoNumber, winningNumbers, bonusNumber)
            ranks.add(getRank(hit to bonus))
        }
        return ranks
    }

    /**
     * 구입한 로또 번호와 당첨 번호를 비교하는 함수
     * */
    private fun compareNumbers(lottoNumber: Lotto, winningNumbers: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        var hit = 0
        var bonus = false
        for (number in lottoNumber.getLottoNumbers()) {
            if (winningNumbers.getLottoNumbers().contains(number)) {
                hit += 1
            }
            if (number == bonusNumber) {
                bonus = true
            }
        }
        return isNecessaryBonus(hit, bonus)
    }

    /**
     * 3등 미만은 보너스 정보가 필요 없으므로 bonus 값을 false로 고정하는 함수
     * */
    private fun isNecessaryBonus(hit: Int, bonus: Boolean): Pair<Int, Boolean> {
        if ((hit < 5) and bonus) {
            return hit to false
        }
        return hit to bonus
    }

    /**
     * 당첨 번호와 일치하는 수, 보너스 번호 일치 여부에 맞춰 등수를 반환하는 함수
     * */
    private fun getRank(hitAndBonus: Pair<Int, Boolean>): Rating {
        when (hitAndBonus) {
            6 to false -> return Rating.FIRST
            5 to true -> return Rating.SECOND
            5 to false -> return Rating.THIRD
            4 to false -> return Rating.FOURTH
            3 to false -> return Rating.FIFTH
        }
        return Rating.LOSE
    }

    /**
     * 당첨 통계 중 순위 당 갯수를 계산하는 함수
     * */
    fun countRank(resultOfLotto: MutableList<Rating>, rating: Rating): Int {
        return resultOfLotto.count { it == rating }
    }

    /**
     * 당첨 통계 중 수익률을 계산하는 함수
     * */
    fun calculateIncome(resultOfLotto: MutableList<Rating>, countOfLotto: Int): Double {
        var sum = 0.0
        for (rank in Rating.values()) {
            sum += countRank(resultOfLotto, rank) * rank.getPrize()
        }
        return round((sum / (countOfLotto * 1000) * 100) * 10) / 10
    }
}