package lotto

fun main() {
    TODO("프로그램 구현")
}

fun moneyValidCheck(a : String) : Int {
    val money : Int
    try{
        money = a.toInt()
    }catch(e : NumberFormatException){
        throw IllegalArgumentException("[ERROR] 제대로 된 형태의 숫자를 입력해 주세요")
    }
    if(money < 1000)
        throw IllegalArgumentException ("[ERROR] 숫자가 1000보다 작습니다.")
    if(money%1000 != 0)
        throw IllegalArgumentException("[ERROR] 숫자가 1000으로 나누어 떨어지지 않습니다.")
    return money
}

