package lotto

class LottoBonusNumberException(private val lottoBonusNumber: String) {

    init {
        isNotInteger()
        isNotLottoNumber()
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

}