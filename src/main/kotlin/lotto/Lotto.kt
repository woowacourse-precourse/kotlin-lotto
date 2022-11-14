package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size==6)
    }

    fun checkLottoAnswer(customerNumbers: List<List<Int>>): List<Int> {
        val res = mutableListOf(0)
        for(i in customerNumbers.indices){
            res.add(countCorrectNumber(customerNumbers[i]))
        }
        return res
    }

    private fun countCorrectNumber(values: List<Int>): Int {
        var count = 0
        for(i in values.indices){
            if(numbers.any {it==values[i]}){
                count++
            }
        }
        return count
    }
}
