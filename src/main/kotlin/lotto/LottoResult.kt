package lotto

class LottoResult {

    enum class WinPrize(val prize : String){
        FIRST("2,000,000,000"),
        SECOND("30,000,000"),
        THIRD("1,500,000"),
        FOURTH("50,000"),
        FIFTH("5,000");
    }

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

    fun getWinningListTotal(lottoCount : Int, totalPublishNums : List<List<Int>>, winNums : List<Int>, bonusNums: Int) : List<String>{
        val totalWinCount = mutableListOf<String>()
        for(i in 0..lottoCount){
            if(getBonusCount(totalPublishNums[i], winNums, bonusNums)){
                totalWinCount.add(WinPrize.valueOf("SECOND").prize)
            }
            else if(!getBonusCount(totalPublishNums[i], winNums, bonusNums)){
                totalWinCount += getWinningWithoutBonus(lottoCount, totalPublishNums, winNums, bonusNums)
            }
        }
        return totalWinCount
    }

    fun getWinningWithoutBonus(lottoCount : Int, totalPublishNums : List<List<Int>>, winNums : List<Int>, bonusNums: Int) : List<String>{
        val winCountWithoutBonus = mutableListOf<String>()
        for(i in 0..lottoCount) {
            when (getWinCount(totalPublishNums[i], winNums)) {
                3 -> winCountWithoutBonus.add(WinPrize.valueOf("FIFTH").prize)
                4 -> winCountWithoutBonus.add(WinPrize.valueOf("FOURTH").prize)
                5 -> winCountWithoutBonus.add(WinPrize.valueOf("THIRD").prize)
                6 -> winCountWithoutBonus.add(WinPrize.valueOf("FIRST").prize)
            }
        }
        return winCountWithoutBonus
    }

    //7. 수익률 계산하는 함수 생성
    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}