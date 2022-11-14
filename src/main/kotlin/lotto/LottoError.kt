package lotto

object LottoError {

    private val costValidNum = "^[0-9]+$".toRegex()

    fun checkMoneyError(money : String){
        if (!money.matches(costValidNum)){
            throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")
        }
        if (money.toInt() % 1000 != 0 || money.toInt() < 1000) {
            throw IllegalArgumentException("[ERROR] 로또 1장의 가격은 1000원입니다.")
        }
    }
}