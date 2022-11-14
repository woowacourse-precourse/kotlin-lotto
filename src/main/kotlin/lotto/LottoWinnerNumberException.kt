package lotto

class LottoWinnerNumberException(private val lottoWinnerNumbers: String) {
    private var _lottoWinnerNumber: List<String> = LottoNumberSplit(lottoWinnerNumbers).getLottoNumbers()

    init {
        // 6개 check는 하지 않음. Lotto 클래스에 require 되있음
        isNotInteger()
        isNotLottoNumber()
    }

    private fun isNotInteger() {
        try {
            for(lottoNumber in _lottoWinnerNumber )
                lottoNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력한 로또 번호 중 정수가 아닌 수가 있습니다.")
        }
    }

    private fun isNotLottoNumber() {
        for(lottoNumber in _lottoWinnerNumber ) {
            if( lottoNumber.toInt() < 1 || lottoNumber.toInt() > 45 ) {
                throw IllegalArgumentException("[ERROR] 입력한 로또 번호 ${lottoNumber}는 존재하지 않습니다.")
            }
        }
    }
}