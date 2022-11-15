package lotto

import camp.nextstep.edu.missionutils.Randoms

class Number{
    fun BuyLottoCount(buy:Int): Int {
        val buy_count=buy/1000
        println("${buy_count}개를 구매했습니다.")
        return buy_count
    }

    fun PrintNumberList(buy_count:Int):MutableList<List<Int>>{
        val total_numbers= mutableListOf<List<Int>>()
        for(i in 1..buy_count){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(numbers.sorted())
            total_numbers.add(numbers.sorted())
        }
        return total_numbers
    }
}