package lotto.utils

import lotto.utils.Constants.LottoPrice

enum class ErrorMessage(val messages: String) {
    ERROR("[ERROR] 에러가 발생했습니다."),
    ERROR_PRICE("[ERROR] 티켓 가격이 아닙니다."),
    ERROR_NUMBER_TYPE("[ERROR] 숫자가 아닙니다."),
    ERROR_DUPLE("[ERROR] 중복된 숫자가 포함되었습니다."),
    ERROR_RANGE("[ERROR] 숫자범위가 초과되었습니다."),
    ERROR_BONUS("[ERROR] 보너스 번호가 이미 사용되었습니다.")
}

class ErrorCheck() {
    fun errorPrice(buyPrice: Int) {
        if (buyPrice % LottoPrice != 0) {
            throw IllegalArgumentException(ErrorMessage.ERROR_PRICE.messages)
        }
    }
    fun errorString(input: String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessage.ERROR_NUMBER_TYPE.messages)
        }
    }
    fun duplicatedNumber(answer : List<Int>){
        val deleteDuple = answer.distinct()
        if (deleteDuple.size != Constants.LottoNumber){
            throw IllegalArgumentException(ErrorMessage.ERROR_DUPLE.messages)
        }
    }

    fun ListnumberRange(numbers : List<Int>){
        for (number in numbers){
            NumberRange(number)
        }
    }

    fun NumberRange(number : Int){
        if (number > 45 || number < 1 ){
                throw IllegalArgumentException(ErrorMessage.ERROR_RANGE.messages)
            }
    }

    fun isNotIncludedNumbers(number : Int, numbers : List<Int>){
        if (number in numbers){
            throw IllegalArgumentException(ErrorMessage.ERROR_BONUS.messages)
        }
    }

}
