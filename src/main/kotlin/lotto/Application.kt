package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun checkUserMoney(userMoney:String){
   var userMoney = userMoney.toIntOrNull()
    if(userMoney == null) {
        print("[ERROR] 숫자를 입력하세요")
        throw IllegalArgumentException()}

    if(userMoney%1000 != 0) {
        print("[ERROR] 1000으로 나누어 떨어지는 수를 입력하세요")
        throw IllegalArgumentException()}
}

fun main() {
   var userMoney = Console.readLine()!!.toString();
    checkUserMoney(userMoney)

}
