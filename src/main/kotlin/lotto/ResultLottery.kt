package lotto
import kotlin.math.round
class ResultLottery(private val ticketTypeCount : MutableList<Int>, private val lottoPay: Int) {
    private val resultLotto = ticketTypeCount[0] * 5000 + ticketTypeCount[1] * 50000 + ticketTypeCount[2] * 1500000 + ticketTypeCount[3] * 3000000 + ticketTypeCount[4] * 2000000000
    private val lottoProfit = round(resultLotto / lottoPay.toFloat() * 1000) /10
    init{
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${ticketTypeCount[0]}개 ")
        println("4개 일치 (50,000원) - ${ticketTypeCount[1]}개 ")
        println("5개 일치 (1,500,000원) - ${ticketTypeCount[2]}개 ")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ticketTypeCount[3]}개 ")
        println("6개 일치 (2,000,000,000원) - ${ticketTypeCount[4]}개")
        println("총 수익률은 ${lottoProfit}%입니다.")
    }
}