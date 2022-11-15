package domain
import utils.ExceptionHandler.throwExceptionForPurchaseMoney

class PurchaseMoney(private val purchaseMoney: Int) {

    init{
        throwExceptionForPurchaseMoney(purchaseMoney)
    }

    fun getPurchaseMoney(): Int {
        return this.purchaseMoney
    }
}