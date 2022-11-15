package lotto

class LottoResult{

    var first = 0
    var second = 0
    var third = 0
    var fourth = 0
    var fifth = 0

    fun getPrizeRanking(totalWinningList : List<Int>){
        totalWinningList.forEach {
            when(it){
                Prize.valueOf("FIFTH").prize -> first++
                Prize.valueOf("SECOND").prize -> second++
                Prize.valueOf("THIRD").prize -> third++
                Prize.valueOf("FOURTH").prize -> fourth++
                Prize.valueOf("FIFTH").prize -> fifth++
            }
        }
    }

    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}