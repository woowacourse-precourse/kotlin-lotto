package lotto

class LottoResult {

    val first = 0
    val second = 0
    val third = 0
    val fourth = 0
    val fifth = 0

    //7. 수익률 계산하는 함수 생성
    fun getEarningRate(inputPrice : Int, winPrice : Int) : String {
        val earningRate = (winPrice.toDouble() / inputPrice) * 100
        val earnRatePercent = String.format("%.2f", earningRate)
        return earnRatePercent
    }

}