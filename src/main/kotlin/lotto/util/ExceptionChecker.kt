package lotto.util

class ExceptionChecker {
    fun priceExceptionCheck(price : Long){
        if((price % 1000).toInt() != 0)
            throw IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.")
    }

    fun validLottoNumExceptionCheck(winningNum: List<Int>){
        for(i in winningNum.indices){
            if(winningNum[i] < 1 || winningNum[i] > 45)
                throw IllegalArgumentException("[ERROR] 로또 번호는 1~45의 정수여야 합니다.")
        }
    }
}