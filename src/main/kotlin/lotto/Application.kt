package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
    var inputMoney = Console.readLine()
}
fun inputMoney(): Int? {
    print("구입금앱을 입력해 주세요.")
    return Console.readLine().toInt()
}
fun validInputMoney(inputMoney : Int){
    if(inputMoney%1000 != 0)
        throw IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.")
}