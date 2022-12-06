package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == numbers.distinct().size)
        if (numbers.size != 6) {
            Error.showError(ErrorType.NotMatchedToLottoLength)
        }
    }
    // TODO: 추가 기능 구현
    fun getUserWinNumbers(list: List<Int>): Int {
        val unionNumbers = numbers.intersect(list)
        return when (unionNumbers.size) {
            3 -> fifth
            4 -> fourth
            5 -> third
            6 -> if(unionNumbers.contains(list.last())) second else first
            else -> notInRank
        }
    }

    companion object {
        private const val first = 0
        private const val second = 1
        private const val third = 2
        private const val fourth = 3
        private const val fifth = 4
        private const val notInRank = 100
    }
}
