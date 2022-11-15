package lotto
class PlayLottery(private val lotto : List<Int>, private val userNum : List<Int>,private val TicketTypeCount : MutableList<Int>,private val userBonus : Int) {
    private val union = lotto + userNum
    private val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
    init{
        if (intersection.count() == 3)
            TicketTypeCount[0]++//5,000원
        if (intersection.count() == 4)
            TicketTypeCount[1]++//50,000원
        if ((intersection.count() == 5) && !(lotto.contains(userBonus)))
            TicketTypeCount[2]++//1,500,000원
        if ((intersection.count() == 5) && (lotto.contains(userBonus)))
            TicketTypeCount[3]++//30,000,000원
        if (intersection.count() == 6)
            TicketTypeCount[4]++//2,000,000,000원
    }
}