package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun createLottoNumbers(purchasedLottoCount : Int) :  {}

    fun compareLottoNumbers(purchasedNumbers : List<Int>){}

    fun calculateEarningRate() : Float{}
}
