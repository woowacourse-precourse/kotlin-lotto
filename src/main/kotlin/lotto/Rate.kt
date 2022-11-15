package lotto

class Rate{
    fun PrintRate(winning_numbers_count: MutableMap<Int, Int>, buy: Int){
        var total_money=0
        for(money in winning_numbers_count.keys){
            total_money+= winning_numbers_count[money]!! *money
        }

        print("총 수익률은 ")
        print(String.format("%.1f",total_money.toFloat()/buy.toFloat()*100))
        print("%입니다.")
    }
}