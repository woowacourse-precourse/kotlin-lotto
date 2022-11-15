package lotto.util

interface OutPutMsg {
    fun errorMsg()
    fun payedMoneyMsg()
    fun bonusMsg()
    fun lottoCountMsg(userInputNumber: String)
    fun winningNumberMsg()
    fun winningMsg(resultWinning: MutableList<Int>)
    fun yieldMsg(yield:String)
}

class OutputMessage : OutPutMsg {
    override fun errorMsg() {
        println("[ERROR]")
    }

    override fun payedMoneyMsg() {
        println("구입금액을 입력해 주세요.")
    }

    override fun bonusMsg() {
        print("보너스 번호를 입력해 주세요.")
    }

    override fun lottoCountMsg(userInputNumber: String) {
        println(userInputNumber.replace("000", "") + "개를 구매했습니다.")
    }

    override fun winningNumberMsg() {
        println("당첨 번호를 입력해 주세요.")
    }

    override fun winningMsg(resultWinning: MutableList<Int>) {
        println("3개 일치 (5,000원) - " + resultWinning[0] + "개")
        println("4개 일치 (50,000원) - " + resultWinning[1] + "개")
        println("5개 일치 (1,500,000원) - " + resultWinning[2] + "개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultWinning[3] + "개")
        println("6개 일치 (2,000,000,000원) - " + resultWinning[4] + "개")
    }

    override fun yieldMsg(yield:String) {
        println("총 수익률은 $`yield`%입니다.")
    }


}