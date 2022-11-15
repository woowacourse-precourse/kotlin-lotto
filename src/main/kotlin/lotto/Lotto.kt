package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        LottoError.checkLottoNum(numbers)
    }

    fun getList(): List<Int> {
        return numbers
    }

    companion object{
        const val INPUTMONEY : String = "구입금액을 입력해 주세요."
        const val SHOWNUMOFLOTTERY : String = "개를 구매했습니다."
        const val INPUTWINMONEY : String = "\n" + "당첨 번호를 입력해 주세요."
        const val INPUTBONUSNUM : String = "\n" + "보너스 번호를 입력해 주세요."
        const val SHOWSTATISTICS : String = "\n" + "당첨 통계" + "\n" + "---"
    }

}
