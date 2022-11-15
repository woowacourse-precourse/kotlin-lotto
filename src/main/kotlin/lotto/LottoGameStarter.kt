package lotto

class LottoGameStarter {
    fun gameStarter(){
        val money = readLine()
        checkMoneyError(money)
    }

    fun checkMoneyError(money:String?){
        if(money!!.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] 금액은 숫자를 입력해야 합니다.")
        if(money.toInt() < 1000) throw IllegalArgumentException("[ERROR] 1000원 이상의 금액을 내야 로또 구입이 가능합니다.")
    }
}
