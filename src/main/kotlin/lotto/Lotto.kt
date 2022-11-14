package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumbers() : List<Int> {
        return numbers
    }

    fun getLottoWinning(winning : MutableList<Int>, bonus: Int) : Int {
        var winCount = 0

        winning.forEach{
            if(numbers.contains(it)){
                winCount++
            }
        }

        if(winCount == 5 && getLottoBonus(bonus)){
            winCount = 7
        }

        return winCount
    }

    fun getLottoBonus(bonus : Int) : Boolean {
        var hasBonus = false

        if(numbers.contains(bonus)){
            hasBonus = true
        }

        return hasBonus
    }


}
