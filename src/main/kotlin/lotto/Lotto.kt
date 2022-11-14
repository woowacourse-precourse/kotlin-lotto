package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size==6)
    }

    fun checkLottoAnswer(customerNumbers: List<List<Int>>, bonusNumber: Int): List<Int> {
        val res = mutableListOf<Int>()
        for(i in customerNumbers.indices){
            res.add(countCorrectNumber(customerNumbers[i],bonusNumber))
        }
        return res
    }

    private fun countCorrectNumber(values: List<Int>,bonusNumber: Int): Int {
        var count = 0
        for(i in values.indices){
            if(numbers.any {it==values[i]}){
                count++
            }
        }
        if(count ==5){
            if(checkBonusNumber(bonusNumber, values)){
                count++
            }
        }
        if(count ==6){
            count++
        }
        return count
    }

    private fun checkBonusNumber(bonusNumber: Int, values: List<Int>): Boolean {
        for(i in values.indices){
            if(values[i]==bonusNumber){
                return true
            }
        }
        return false
    }
}
