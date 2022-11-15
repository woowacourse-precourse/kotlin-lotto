package lotto

import camp.nextstep.edu.missionutils.Randoms

class MainView {

    fun getLottoPrice() : Int? {
        println(PURCHASE_MSG)
        val lottoPrice = readLine()?.toInt()
        if (lottoPrice != null) {
            LottoExecptions().getInputLottoPriceUnitException(lottoPrice)
        }
        return lottoPrice
    }

    fun showLottoNums(lottoNums : Int, createdLottos : List<List<Int>>){

        println(lottoNums.toString() + PURCHASE_COUNT_MSG)
        for(i in 0..lottoNums){
            println(createdLottos[i])
        }
    }

    fun getWinNums() : String? {
        println(GET_LOTTO_INPUT_MSG)
        val winNums = readLine()
        //당첨 번호를 양식에 맞게 입력하지 않았을 때의 예외 사항 처리 필요
        return winNums
    }

    fun getBonusNum(): Int? {
        println(GET_BONUS_INPUT_MSG)
        //보너스 번호가 양식에 맞게 입력되지 않았을 때의 예외 사항 처리 필요
        return readLine()?.toInt()
    }

    fun winTotal(winCount : List<Int>, earningRate : String){
        println(WIN_TOTAL_GUIDE_MSG)
        println(WIN_TOTAL_DIVIDE_LINE)
        println(WIN_FIFTH_MSG + winCount[0] + COUNT_UNIT)
        println(WIN_FOURTH_MSG + winCount[1] + COUNT_UNIT)
        println(WIN_THIRD_MSG + winCount[2] + COUNT_UNIT)
        println(WIN_SECOND_MSG + winCount[3] + COUNT_UNIT)
        println(WIN_FIRST_MSG + winCount[4] + COUNT_UNIT)
        println(EARNING_RATE_START_MSG + earningRate + EARNING_RATE_END_MSG)
    }

    companion object{
        const val PURCHASE_MSG = "구입금액을 입력해 주세요."
        const val PURCHASE_COUNT_MSG = "개를 구매했습니다."
        const val GET_LOTTO_INPUT_MSG = "당첨 번호를 입력해 주세요."
        const val GET_BONUS_INPUT_MSG = "보너스 번호를 입력해 주세요."

        const val WIN_TOTAL_GUIDE_MSG = "당첨 통계"
        const val WIN_TOTAL_DIVIDE_LINE = "---"

        const val WIN_FIFTH_MSG = "3개 일치 (5,000원) - "
        const val WIN_FOURTH_MSG = "4개 일치 (50,000원) - "
        const val WIN_THIRD_MSG = "5개 일치 (1,500,000원) - "
        const val WIN_SECOND_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val WIN_FIRST_MSG = "개 일치 (2,000,000,000원) - "

        const val EARNING_RATE_START_MSG = "총 수익률은"
        const val EARNING_RATE_END_MSG = "%입니다."

        const val COUNT_UNIT = "개"
    }

}