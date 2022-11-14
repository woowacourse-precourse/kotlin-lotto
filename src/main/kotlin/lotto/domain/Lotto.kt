package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) {"[ERROR]: 로또 번호의 개수는 6개여야 합니다."}
        isLottoNumberDuplicated(numbers)
        hasLottoNumberValidRange()
    }

    private fun hasLottoNumberValidRange() {
        for (number in numbers) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                throw IllegalArgumentException("[ERROR]: 로또 번호는 1~45 사이의 숫자여야 한다.")
            }
        }
    }

    private fun isLottoNumberDuplicated(lottoNumList: List<Int>) {
        if (lottoNumList.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR]: 로또는 중복되지 않는 6개의 숫자를 가져야 한다.")
        }
    }

    fun getLottoNumberList(): List<Int> {
        return numbers
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}