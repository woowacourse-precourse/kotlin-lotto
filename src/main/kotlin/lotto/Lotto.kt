package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        LottoError.checkLottoNum(numbers)
    }

    fun getList(): List<Int> {
        return numbers
    }

}
