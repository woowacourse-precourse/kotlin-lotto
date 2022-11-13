package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun computeResult(other: Lotto): LottoResult {
        val matchedResult = other.numbers.filter {
            this.numbers.contains(it)
        }.size

        return when (matchedResult){
            3 -> LottoResult.ThreeMatch
            4 -> LottoResult.FourMatch
            5 -> LottoResult.FiveMatch
            6 -> LottoResult.SixMatch
            else -> LottoResult.ElseMatch
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}

enum class LottoResult(val price: Int) {
    ThreeMatch(5000), FourMatch(50000), FiveMatch(1500000), SixMatch(2000000000), ElseMatch(0)
}