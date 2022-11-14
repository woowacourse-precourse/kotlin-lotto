package lotto

private const val DOLLAR = 1000

class LottoValidCheker {

    fun checkDollar(amount: Int): Boolean = amount % DOLLAR != 0
    fun checkPositive(amount: Int): Boolean = amount <= 0
}