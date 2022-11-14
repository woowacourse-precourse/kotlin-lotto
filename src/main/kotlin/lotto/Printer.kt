package lotto

class Printer {
    fun printGetPurchaseAmountMessage(){
        println("구입금액을 입력해 주세요.")
    }

    fun printGetWinningNumberMessage(){
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printGetBonusNumberMessage(){
        println("\n보너스 번호를 입력해 주세요.")
    }

    fun printWinningResult(winningResult: HashMap<String, Int>){

        println("\n당첨 통계\n---")

        println("3개 일치 (5,000원) - ${winningResult.getValue("threeWin")}개")
        println("4개 일치 (50,000원) - ${winningResult.getValue("fourWin")}개")
        println("5개 일치 (1,500,000원) - ${winningResult.getValue("fiveWin")}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult.getValue("fiveWithBonusWin")}개")
        println("6개 일치 (2,000,000,000원) - ${winningResult.getValue("sixWin")}개")
    }

    fun printYieldResult(rate : Double){
        println("총 수익률은 ${rate}%입니다.")
    }

}