package lotto
import kotlin.math.*
class Lotto(_numbers: List<Int>, _bonus: Int) {
    private var numbers = mutableListOf<Int>()
    init {
        try {
            require(_numbers.size == 6)
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 6개만 입력해야 합니다.")
        }
        lottoAnswer(_numbers)
        lottoBonus(_numbers, _bonus)
        numbers.addAll(_numbers)
        numbers.add(_bonus)
        for(i in 0 until userLottoList.size){
            LottoStats.lottoMatchLists(userLottoList[i], numbers)
        }
        var sumPrice = 0
        println("\n당첨 통계\n---")
        LottoStats.values().forEach{
            println("${it.message} - ${it.Cnt}개")
            sumPrice += (it.price/1000 * it.Cnt)
        }
        val rateOfReturn = ((sumPrice.toDouble() / userLottoList.size.toDouble())*100.0)
        println("총 수익률은 ${round(rateOfReturn*10)/10}%입니다.")
    }

    private fun lottoAnswer(answers : List<Int>) {
        if(answers.size != (answers.filter{ it in 1..45 }).size){
            throw IllegalArgumentException("[ERROR] 1부터 45 숫자를 입력하셔야 합니다.")
        } else if (answers.size != answers.distinct().size){
            throw IllegalArgumentException("[ERROR] 중복이 없어야 합니다.")
        }
    }

    private fun lottoBonus(numbers: List<Int>, bonus : Int){
        if(bonus !in 1..45){
            throw IllegalArgumentException("[ERROR] 1부터 45 숫자를 입력하셔야 합니다.")
        } else if (numbers.contains(bonus)){
            throw IllegalArgumentException("[ERROR] 정답과 숫자와 중복이 없어야 합니다.")
        }
    }
}
