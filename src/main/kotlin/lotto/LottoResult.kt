package lotto

class LottoResult {

    //6-1. 당첨 숫자를 게산하는 함수 생성
    fun getWinCount(publishNums: List<Int>, winNums : List<Int>) : Int{
        var winCount = 0
        val commonNums = publishNums.filter { it in winNums.map { item -> item } }
        winCount = commonNums.size
        return winCount
    }

    fun getBonusCount(publishNums: List<Int>, winNums : List<Int>, bonusNums: Int) : Boolean {
        var isBonusWin = false
        if(getWinCount(publishNums, winNums) == 5){
            isBonusWin = publishNums.any{ it == bonusNums }
        }
        return isBonusWin
    }

    //7. 수익률 계산하는 함수 생성
    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}