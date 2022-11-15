package lotto.domain

class InputValidation {

    fun checkInputInteger(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INTEGER_ERROR_MESSAGE)
        }
    }

    fun checkAmountMultipleOfThousand(amount:Int):Int{
        if(amount % LOTTO_PRICE!=0) throw IllegalArgumentException(MULTIPLE_OF_THOUSAND_ERROR_MESSAGE)
        return amount
    }

    fun checkInputSplitWithComma(input:String):List<String>{
        val winningNumbers=input.split(",")
        if(winningNumbers.size!=WINNING_NUMBER_COUNT) throw java.lang.IllegalArgumentException(SPLIT_WITH_COMMA_ERROR_MESSAGE)
        return winningNumbers
    }

    fun checkBonusNumberRange(bonusNumber: Int){
        if(bonusNumber< Lotto.MIN_NUMBER || bonusNumber> Lotto.MAX_NUMBER) throw IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE)
    }

    fun checkWinningNumberContainBonusNumber(winningNumbers:List<Int>, bonusNumber: Int){
        if(winningNumbers.contains(bonusNumber)) throw IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val WINNING_NUMBER_COUNT = 6
        const val INTEGER_ERROR_MESSAGE = "[ERROR] 정수를 입력해 주셔야 합니다."
        const val MULTIPLE_OF_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000의 배수 단위로 구매 금액을 입력해 주셔야 합니다."
        const val SPLIT_WITH_COMMA_ERROR_MESSAGE = "[ERROR] 숫자 6개를 ,로 구분해 주세요"
        const val BONUS_NUMBER_RANGE_ERROR_MESSAGE ="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        const val BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE ="[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
    }
}