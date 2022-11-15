package lotto

class Number{
    fun BuyLottoCount(buy:Int): Int {
        val buy_count=buy/1000
        println("${buy_count}개를 구매했습니다.")
        return buy_count
    }
}