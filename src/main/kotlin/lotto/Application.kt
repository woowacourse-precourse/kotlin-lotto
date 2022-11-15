package lotto

import camp.nextstep.edu.missionutils.Randoms

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

fun lottoMaker(lottoCount : Int) : MutableList<Lotto>{
    var lottoPack : MutableList<Lotto> = mutableListOf()
    for(i : Int in 1..lottoCount){
        lottoPack.add(Lotto(Randoms.pickUniqueNumbersInRange(1,45,6).sorted()))
        lottoPack[i-1].printLotto()
    }
    return lottoPack
}

