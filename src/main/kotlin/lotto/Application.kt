package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해주세요")
    var lottoPay = Console.readLine()
    chkNum(lottoPay)
    if(lottoPay.toInt()%1000 != 0){
        println("[ERROR] 금액을 1000원 단위로 입력해주세요")
        throw IllegalArgumentException()
    }

    var lottoTicket : Int = lottoPay.toInt()/1000

    println("${lottoTicket}개를 구매했습니다.")
    var lotto = mutableListOf<List<Int>>()
    PrintLottery(lottoTicket,lotto)
    println("당첨 번호를 입력해 주세요.")

    //5등,4등,3등,2등,1등 티켓 종류 세기
    var ticketTypeCount= mutableListOf<Int>(0,0,0,0,0)

    var userNum= Console.readLine().split(",").map{it.toInt()}
    Lotto(userNum)
    println("보너스 번호를 입력해주세요")
    var userBonus = Console.readLine().toInt()
    if(userNum.contains(userBonus)){
        println("[ERROR] 보너스 번호가 당첨 번호의 숫자와 겹칩니다.")
        throw IllegalArgumentException()
    }
    if(userBonus > 45 || userBonus < 1){
        println("[ERROR] 보너스 번호는 1~45 범위의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
    for (i in 0 until lotto.size)
        PlayLottery(lotto[i], userNum,ticketTypeCount,userBonus)

    ResultLottery(ticketTypeCount,lottoPay.toInt())

}
fun chkNum(str: String) {
    var temp: Char

    for (i in 0 until str.length) {
        temp = str.elementAt(i)
        if (!(temp.isDigit())) {
            print("[ERROR] 숫자를 입력해주세요")
            throw NoSuchElementException()
        }
    }

}
