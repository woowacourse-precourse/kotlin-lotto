package lotto

class LottoResult {

    //6-1. 당첨 숫자를 게산하는 함수 생성
    fun getWinCount(publishNums: List<Int>, winNums : List<Int>, bonusNums : Int) : Int{
        var winCount = 0
        val commonNums = publishNums.filter { it in winNums.map { item -> item } }
        winCount = commonNums.size
        if(winCount == 5 && publishNums.any{ it == bonusNums }) winCount += 1
        return winCount
    }

    //7. 수익률 계산하는 함수 생성
    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}