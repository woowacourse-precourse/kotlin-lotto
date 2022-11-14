package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class domain {
    fun lottoNumberCalculate(money : Int) : Int {
        var lottoNumber = money / 1000
        println(lottoNumber.toString() +"개를 구매했습니다.")
        return lottoNumber
    }

    fun lottoPublish(lottoNumber : Int) : MutableList<List<Int>> {
        var lottoPublishment = mutableListOf<List<Int>>()
        for (i in 0 until lottoNumber){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoPublishment.add(numbers.sorted())
        }
        for (i in 0 until lottoPublishment.size){
            println(lottoPublishment[i])
        }
        return lottoPublishment
    }
}