package lotto.exception

class HandleInput {
    fun moneyException(money:Int){
        if(money % 1000 != 0){
            throw IllegalArgumentException("[ERROR] 금액이 1,000원으로 나누어 떨어지지 않습니다.")
        }
    }
}