package lotto
import camp.nextstep.edu.missionutils.Randoms
class LottoNumGenerator {

    fun makeLottoNum(amount : Int): List<List<Int>>{
        var lottoList = mutableListOf<List<Int>>()
        for(order in 1..amount){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(numbers)
            lottoList.add(numbers)
        }
        return lottoList.toList()
    }
}