package lotto.util

class ExceptionChecker {
    fun priceExceptionCheck(price : String){

        require(price.all { it.isDigit() }){ println("[ERROR] 구입 금액은 숫자로 입력되어야 합니다.") }
        val priceToLong = price.toLong()
        require((priceToLong % 1000).toInt() == 0){ println("[ERROR] 로또는 1000원 단위로 구매 가능합니다.") }

    }

    fun validLottoNumExceptionCheck(winningNum: List<Int>){
        for(i in winningNum.indices)
            require(winningNum[i] in 1 .. 45){ println("[ERROR] 로또 번호는 1~45의 정수여야 합니다.") }
    }

    fun validBonusNumExceptionCheck(winningNum: List<Int>, bonusNum: Int){
        require(bonusNum in 1..45){ println("[ERROR] 보너스 번호는 1~45의 정수여야 합니다.") }
        require(!winningNum.contains(bonusNum)){ println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.") }
    }
}