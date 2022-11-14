package lotto

class Lotto(private val numbers: List<Int>) {
    val util = Util()
    init {
        require(numbers.size == 6){
            throw IllegalArgumentException("[ERROR] 로또 번호의 개수가 잘못되었습니다.")
        }
        util.isRightRange(numbers)
        util.isOverlap(numbers)
    }

    fun getLottoNum() : List<Int>{
        return numbers
    }
}
