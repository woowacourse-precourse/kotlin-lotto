package lotto

import camp.nextstep.edu.missionutils.Console.*
import kotlin.properties.Delegates

class Customer() {
    fun getMainLottoNumbers(): List<String> = readLine().split(",")

    fun getBonusLottoNumber(): String = readLine()

    fun getPurchaseAmount(): String = readLine()

    companion object {
        var mainLottoNumbers = listOf<Int>()
            private set
        var bonusLottoNumber by Delegates.notNull<Int>()
            private set
        var purchaseAmount by Delegates.notNull<Int>()
            private set

        fun updateMainLottoNumbers(mainLottoNumbers: List<Int>) {
            this.mainLottoNumbers = mainLottoNumbers
        }

        fun updateBonusLottoNumber(bonusLottoNumber: Int) {
            this.bonusLottoNumber = bonusLottoNumber
        }

        fun updatePurchaseAmount(purchaseAmount: Int) {
            this.purchaseAmount = purchaseAmount
        }
    }
}
