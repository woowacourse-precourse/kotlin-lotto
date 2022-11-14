package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.*
import java.lang.IllegalArgumentException

lateinit var user:User
lateinit var lottoNums:List<Lotto>


fun inputPurchasingAmount():Int{
    println(INPUT_PURCHASE_AMOUNT_MSG)
    try{
        user= User(Console.readLine())
    }catch (e:IllegalArgumentException){
        return -1
    }

    return 0
}
fun makeLottoWinNumbers() :Int{
    try {
        lottoNums = List(user.numOfLotto) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }
    catch (e: IllegalArgumentException){
        return -1
    }

    return 0
}
fun printLottoWinNumbers(){
    println(user.numOfLotto.toString()+ NUM_OF_LOTTO_MSG)
    for(case in lottoNums) case.printLottoWinNum()
}


fun main() {
    if(inputPurchasingAmount()==-1) return
    if(makeLottoWinNumbers()==-1)return
    printLottoWinNumbers()


}