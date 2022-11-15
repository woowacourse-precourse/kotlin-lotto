package lotto

class PurchaseValueException(private val purchaseValue: String) {

    init {
        isNotInteger()
        isNegativeNumber()
        isNotUnitThousand()
    }

    private fun isNotInteger() {
        try{
            purchaseValue.toInt()
        }catch(e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력한 구매 금액이 정수가 아닙니다.")
        }
    }

    private fun isNegativeNumber() {
        if(purchaseValue.toInt() < 0) {
            throw IllegalArgumentException("[ERROR] 입력한 구매 금액이 양수가 아닙니다.")
        }
    }

    private fun isNotUnitThousand() {
        if(purchaseValue.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 입력한 구매 금액이 천원 단위가 아닙니다.")
        }
    }
}