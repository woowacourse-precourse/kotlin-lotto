package lotto

class LottoBonusNumberException(private val lottoBonusNumber: String, private val lottoWinnerNumber: List<String>) {

    init {
        isNotInteger()
        isNotLottoNumber()
        isOverlap()
    }

    private fun isNotInteger() {
        try{
            lottoBonusNumber.toInt()
        }catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력한 보너스 번호 ${lottoBonusNumber}는 정수가 아닙니다.")
        }
    }

    private fun isNotLottoNumber() {
        if(lottoBonusNumber.toInt() < 1 || lottoBonusNumber.toInt() > 45)
            throw IllegalArgumentException("[ERROR] 입력한 로또 번호 ${lottoBonusNumber}는 존재하지 않습니다.")
    }

    private fun isOverlap() {
        if(lottoWinnerNumber.contains(lottoBonusNumber))
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.")
    }
}