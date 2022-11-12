package lotto.domain

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String =
        numbers.joinToString(", ", "[", "]")
}
