package lotto.domain

class InputValidation {

    fun checkInputInteger(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE)
        }
    }

    fun checkAmountMultipleOfThousand(amount:Int):Int{
        if(amount % LOTTO_PRICE!=0) throw IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE)
        return amount
    }

    fun checkInputSplitWithComma(input:String):List<String>{
        val winningNumbers=input.split(",")
        if(winningNumbers.size!=WINNING_NUMBER_COUNT) throw java.lang.IllegalArgumentException(NOT_SPLIT_WITH_COMMA_ERROR_MESSAGE)
        return winningNumbers
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val WINNING_NUMBER_COUNT = 6
        const val NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 정수를 입력해 주셔야 합니다."
        const val NOT_MULTIPLE_OF_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000의 배수 단위로 구매 금액을 입력해 주셔야 합니다."
        const val NOT_SPLIT_WITH_COMMA_ERROR_MESSAGE = "[ERROR] 숫자 6개를 ,로 구분해 주세요"
    }
}