package lotto

import camp.nextstep.edu.missionutils.Console.*
import kotlin.properties.Delegates

class Customer() {
    fun getMainLottoNumbers(): List<String> = readLine().split(",")

    fun getBonusLottoNumber(): String = readLine()

    companion object {
        var mainLottoNumbers = listOf<Int>()
        var bonusLottoNumber by Delegates.notNull<Int>()

        fun updateMainLottoNumbers(mainLottoNumbers: List<Int>) {
            this.mainLottoNumbers = mainLottoNumbers
        }

        fun updateBonusLottoNumber(bonusLottoNumber: Int) {
            this.bonusLottoNumber = bonusLottoNumber
        }
    }
}
