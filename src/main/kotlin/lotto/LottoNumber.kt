package lotto

class LottoNumber(private val lottoNumber: Int) {

    init {
        require(isValidNumberRange())
    }

    private fun isValidNumberRange(): Boolean =
        lottoNumber in 1 until 46
}