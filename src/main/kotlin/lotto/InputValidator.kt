package lotto.domain

object InputValidator {
    fun validateMoney(money:Int) = (money > 0) && (money % 1000 == 0)

}