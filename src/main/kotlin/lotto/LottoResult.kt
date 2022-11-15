package lotto

class LottoResult {

    var first = 0
    var second = 0
    var third = 0
    var fourth = 0
    var fifth = 0

    fun getPrizeRanking(){

    }

    //7. 수익률 계산하는 함수 생성
    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}