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
        return Lotto(inputWinningNumber
            .split(",")
            .map { it.toInt() })
    }

    /**
     * 보너스 번호를 입력받고 예외 처리 후 리턴하는 함수
     * */
    fun getBonusNumber(winningNumbers: Lotto): Int {
        val inputBonusNumber = Util.readLine()
        checkInputBonusNumber(winningNumbers, inputBonusNumber)
        return inputBonusNumber.toInt()
    }

    /**
     * 당첨 여부 정보를 리턴하는 함수
     * */
    fun isWinningLotto(lottoNumbers: MutableList<Lotto>, winningNumbers: Lotto, bonusNumber: Int): MutableList<Rating> {
        val grades: MutableList<Rating> = mutableListOf()
        for (lottoNumber in lottoNumbers) {
            val (hit, bonus) = compareNumbers(lottoNumber, winningNumbers, bonusNumber)
            grades.add(getGrade(hit to bonus))
        }
        return grades
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
    private fun getGrade(hitAndBonus: Pair<Int, Boolean>): Rating {
        when (hitAndBonus) {
            6 to false -> return Rating.FIRST
            5 to true -> return Rating.SECOND
            5 to false -> return Rating.THIRD
            4 to false -> return Rating.FOURTH
            3 to false -> return Rating.FIFTH
        }
        return Rating.LOSE
    }
}