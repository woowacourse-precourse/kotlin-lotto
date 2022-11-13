package lotto.view

import camp.nextstep.edu.missionutils.Console

class LottoView {

    fun getInputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine()
        validMoneyMount(inputMoney)
        return inputMoney.toInt()
    }

    private fun validMoneyMount(inputMoney: String) {
        if (!isNumber(inputMoney) || inputMoney.toInt() % PRICE_PER_LOTTO != 0 || inputMoney.toInt() == 0) {
            throw IllegalArgumentException("[ERROR]: 1,000원 단위의 숫자로만 입력되어야 합니다.")
        }
    }

    fun getWinningLotto(): List<Int> {
        val WinningLottoNumbers = mutableListOf<Int>()
        println("당첨 번호를 입력해 주세요.")
        val inputWinningLottoNumbers = Console.readLine()
        val list = inputWinningLottoNumbers.split(",")
        validWinningLotto(list)
        for (eachLottoNumber in list) {
            WinningLottoNumbers.add(eachLottoNumber.toInt())
        }
        return WinningLottoNumbers
    }

    private fun validWinningLotto(lottoNumList: List<String>) {
        for (lottoNum in lottoNumList) {
            if (!isNumber(lottoNum) || !isValidNumberRange(lottoNum.toInt())) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun getBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine()
        if (!isNumber(inputBonusNumber) || !isValidNumberRange(inputBonusNumber.toInt())) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return inputBonusNumber.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidNumberRange(bonusNumber: Int): Boolean {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return true
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}