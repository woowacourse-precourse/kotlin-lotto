package lotto.util

class ExceptionChecker {
    fun priceExceptionCheck(price : Long){
        if((price % 1000).toInt() != 0)
            throw IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.")
    }
}