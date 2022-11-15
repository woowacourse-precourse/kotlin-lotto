package lotto

class LottoNumberSplit(lottoNumber: String) {
    private var _lottoNumbers: List<String>
    private var _lottoNumber: String

    init {
        _lottoNumber = removeSpaceInLottoNumber(lottoNumber)
        _lottoNumbers = splitLottoNumber(_lottoNumber)
    }

    fun removeSpaceInLottoNumber(lottoNumber: String): String {
        return lottoNumber.replace(" ", "")
    }

    fun splitLottoNumber(lottoNumbers: String): List<String> {
        return lottoNumbers.split(',')
    }

    fun getLottoNumbers(): List<String> {
        return _lottoNumbers
    }
}