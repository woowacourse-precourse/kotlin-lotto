package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        isLottoNumberDuplicated(numbers)
    }

    private fun isLottoNumberDuplicated(lottoNumList: List<Int>) {
        if (lottoNumList.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR]: 로또는 중복되지 않는 6개의 숫자를 가져야 한다.")
        }
    }
}