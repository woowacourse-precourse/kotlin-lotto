package lotto.View

import lotto.*

class MessageOutput {
    enum class Notice(val messages: String) {
        START("구입금액을 입력해 주세요."),
        BUY("개를 구매했습니다."),
        ANSWER("당첨 번호를 입력해 주세요."),
        BONUS("보너스 번호를 입력해 주세요."),
        AVERAGE("당첨 통계"),
    }

    enum class Match(val messages: String) {
        THREE("3개 일치 (5,000원) - "),
        FOUR("4개 일치 (50,000원) - "),
        FIVE("5개 일치 (1,500,000원) - "),
        BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX("6개 일치 (2,000,000,000원) - "),
        EARNF("총 수익률은"),
        EARNB("입니다.")
    }

    fun printStartMessage() {
        println(Notice.START.messages)
    }
    fun printBuyMessage(ticket: Int, list: MutableList<List<Int>>) {
        println("$ticket${Notice.BUY.messages}")
        for (number in 0..ticket - 1)
            println(list[number])
    }

    fun printAnswerInputMessage(){
        println(Notice.ANSWER.messages)
    }

    fun printBonusInputMessage(){
        println(Notice.BONUS.messages)
    }

    fun printAverageInputMessage(){
        println(Notice.AVERAGE.messages)
    }

    fun printMatchedNumberMessage(){
        println(Match.THREE.messages + matchedThree + "개")
        println(Match.FOUR.messages + matchedFour + "개")
        println(Match.FIVE.messages + matchedFive + "개")
        println(Match.BONUS.messages + matchedBonus + "개")
        println(Match.SIX.messages + matchedSix + "개")
        println(Match.EARNF.messages + Match.EARNB.messages )
    }

}