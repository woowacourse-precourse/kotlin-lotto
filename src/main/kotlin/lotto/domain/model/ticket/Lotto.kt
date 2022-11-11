package lotto.domain.model.ticket

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumbers(): List<Int> = numbers
}
