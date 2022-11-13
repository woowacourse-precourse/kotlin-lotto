package lotto

class Message {


    companion object{
        const val INPUT_MONEY_MASSAGE = "구입금액을 입력해 주세요."
        const val COUNT_MASSAGE = "개를 구매했습니다."
        const val INPUT_WINNING_MASSAGE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_MASSAGE = "보너스 번호를 입력해 주세요."
        const val ERROR_MASSAGE = "[ERROR]"
    }
    fun printTickets(lotteryTickets: List<String>) {
        println("${lotteryTickets.size}" + COUNT_MASSAGE)
        lotteryTickets.forEach { println(it) }
    }


}
