package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constants.*
import java.lang.IllegalArgumentException

lateinit var user:User


fun inputPurchasingAmount():Int{
    println(INPUT_PURCHASE_AMOUNT_MSG)
    try{
        user= User(Console.readLine())
    }catch (e:IllegalArgumentException){
        return -1
    }

    return 0
}
fun main() {
    if(inputPurchasingAmount()==-1) return

}