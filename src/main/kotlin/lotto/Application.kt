package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

fun main() {
    println("구입금액을 입력해주세요")
    var lottoPay = Console.readLine()
    var lottoTicket : Int
    chkNum(lottoPay)
    if(lottoPay.toInt()%1000 != 0){
        println("[ERROR] 금액을 1000원 단위로 입력해주세요")
        throw IllegalArgumentException()
    }

    lottoTicket = lottoPay.toInt()/1000

    println("${lottoTicket}개를 구매했습니다.")
    var lotto = mutableListOf<List<Int>>()
    playTicket(lottoTicket,lotto)
    println("당첨 번호를 입력해 주세요.")

    //5등,4등,3등,2등,1등 티켓 종류 세기
    var ticketTypeCount= mutableListOf<Int>(0,0,0,0,0)
    var resultLotto = 0

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
        playLottery(lotto[i], userNum,ticketTypeCount,userBonus)

    resultLotto = ticketTypeCount[0] * 5000 + ticketTypeCount[1] * 50000 + ticketTypeCount[2] * 1500000 + ticketTypeCount[3] * 3000000 + ticketTypeCount[4] * 2000000000
    var lottoProfit = round(resultLotto / lottoPay.toFloat() * 1000) /10
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${ticketTypeCount[0]}개 ")
    println("4개 일치 (50,000원) - ${ticketTypeCount[1]}개 ")
    println("5개 일치 (1,500,000원) - ${ticketTypeCount[2]}개 ")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ticketTypeCount[3]}개 ")
    println("6개 일치 (2,000,000,000원) - ${ticketTypeCount[4]}개")
    println("총 수익률은 ${lottoProfit}%입니다.")
}
fun chkNum(str: String) {
    var temp: Char
    var result = false

    for (i in 0 until str.length) {
        temp = str.elementAt(i)
        if (!(temp.isDigit())) {
            print("[ERROR] 숫자를 입력해주세요")
            throw NoSuchElementException()
        }
    }

}

fun playLottery(lotto : List<Int>, userNum : List<Int>,TicketTypeCount : MutableList<Int>,userBonus : Int){
    val union = lotto+userNum
    val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
    if (intersection.count() == 3)
        TicketTypeCount[0]++//5000원
    if (intersection.count() == 4)
        TicketTypeCount[1]++//50000원
    if ((intersection.count() == 5) && !(lotto.contains(userBonus)))
        TicketTypeCount[2]++//1,500,000원
    if ((intersection.count() == 5) && (lotto.contains(userBonus)))
        TicketTypeCount[3]++//30,000,000원
    if (intersection.count() == 6)
        TicketTypeCount[4]++//2,000,000,000원
}

fun playTicket( lottoTicket : Int, lotto: MutableList<List<Int>>){
    for(i in 0 until lottoTicket){
        val numbers = Randoms.pickUniqueNumbersInRange(1,46,6)
        println(numbers)
        lotto.add(numbers)
    }
}