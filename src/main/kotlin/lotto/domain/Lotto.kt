package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        try {
            require(numbers.size == 6)
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: 로또 번호의 개수는 6개여야 합니다.")
        }

        isLottoNumberDuplicated(numbers)
    }

    private fun isLottoNumberDuplicated(lottoNumList: List<Int>) {
        if (lottoNumList.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR]: 로또는 중복되지 않는 6개의 숫자를 가져야 한다.")
        }
    }

    fun getLottoNumberList(): List<Int> {
        return numbers
    }
}