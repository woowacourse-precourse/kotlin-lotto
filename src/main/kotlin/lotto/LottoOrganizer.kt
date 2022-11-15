package lotto

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {


    fun printInputLottoWinNumber() {
        println(LottoProcessStatement.INPUT_LOTTO_WIN_NUMBER)
    }

    fun printInputLottoBonusNumber() {
        println(LottoProcessStatement.INPUT_LOTTO_BONUS_NUMBER)
    }

}