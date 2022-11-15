package lotto.lottoStore

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.distinct().size==6)
    }
    fun contains():Boolean {
        if (numbers.distinct().size != 6) {
         return true
        }
        return false
    }
    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getValue(): List<Int> {
        return  numbers
    }
}
// TODO: 추가 기능 구현



