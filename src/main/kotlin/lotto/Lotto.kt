package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun computeResult(other: Lotto, bonusNumber: Int): LottoResult {
        val matchedResult = other.numbers.filter {
            this.numbers.contains(it)
        }.size

        return when (matchedResult) {
            3 -> LottoResult.ThreeMatch
            4 -> LottoResult.FourMatch
            5 -> {
                if (other.containBonus(bonusNumber)) {
                    LottoResult.FiveMatchWithBonus
                }
                LottoResult.FiveMatch
            }
            6 -> LottoResult.SixMatch
            else -> LottoResult.ElseMatch
        }
    }

    fun containBonus(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    override fun toString(): String {
        return numbers.toString()
    }
}

enum class LottoResult(val price: Int) {
    ThreeMatch(5_000),
    FourMatch(50_000),
    FiveMatch(1_500_000),
    FiveMatchWithBonus(30_000_000),
    SixMatch(2_000_000_000),
    ElseMatch(0)
}