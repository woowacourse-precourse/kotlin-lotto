package lotto.domain.lotto

class LottoNumber(private val lottoNumber: Int) {

    init {
        require(isValidNumberRange()) { println(IS_NUMBER_RANGE) }
    }

    private fun isValidNumberRange(): Boolean =
        lottoNumber in 1 until 46

    companion object {
        private const val IS_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자야야 합니다."
    }
}