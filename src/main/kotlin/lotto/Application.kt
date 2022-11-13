package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해주세요")
    var lottoPay = Console.readLine()
    var lottoTicket : Int
    if(chkNum(lottoPay)){
        print("[ERROR] 숫자만 입력해주세요")
        throw NoSuchElementException()
    }
    if(lottoPay.toInt()%1000 != 0){
        println("[ERROR] 금액을 1000원 단위로 입력해주세요")
        throw IllegalArgumentException()
    }

    lottoTicket = lottoPay.toInt()/1000

    println("${lottoTicket}개를 구매했습니다.")
    var lotto = mutableListOf<List<Int>>()
    while(lottoTicket > 0){
        val numbers = Randoms.pickUniqueNumbersInRange(1,46,6).sorted()
        println(numbers)
        lotto.add(numbers)
        lottoTicket = lottoTicket!! - 1
    }
    println("당첨 번호를 입력해 주세요.")

    var won_5000 = 0
    var won_50000 = 0
    var won_1500000 = 0
    var won_3000000 = 0
    var won_2000000000 = 0
    var resultLotto = 0

    var userNum= Console.readLine().split(",").map{it.toInt()}
    Lotto(userNum)
    var userBonus = Console.readLine().toInt()
    for (i in 0 until lotto.size){
        val union = lotto[i]+userNum
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        if (intersection.count() == 3)
            won_5000++
        if (intersection.count() == 4)
            won_50000++
        if ((intersection.count() == 5) && !(lotto[i].contains(userBonus)))
            won_1500000++
        if ((intersection.count() == 5) && (lotto[i].contains(userBonus)))
            won_3000000++
        if (intersection.count() == 6)
            won_2000000000++
    }
}
fun chkNum(str: String) : Boolean {
    var temp: Char

    var result = false

    for (i in 0 until str.length) {
        temp = str.elementAt(i)
        if (temp.toInt() < 48 || temp.toInt() > 57) {
            result = true
        }
    }

    return result
}