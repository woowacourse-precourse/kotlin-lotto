package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumbers() : List<Int> {
        return numbers
    }

    fun getLottoWinning(winning : MutableList<Int>) {
        var winCount = 0

        winning.forEach{
            if(numbers.contains(it)){
                winCount++
            }
        }

    }

    fun getLottoBonus(bonus : Int) {
        var hasBonus = false

        if(numbers.contains(bonus)){
            hasBonus = true
        }
    }

}
