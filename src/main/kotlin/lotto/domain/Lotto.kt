package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumberCountException()
        checkNumberRangeException()
        checkDuplicateNumberException()
    }

    fun checkLottoNumberCountException(){
        if(this.numbers.size!= LOTTO_NUMBER_COUNT) throw IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE)
    }

    fun checkNumberRangeException(){
        this.numbers.forEach{number->
            if(number< MIN_NUMBER || number> MAX_NUMBER) throw IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE)
        }
    }

    fun checkDuplicateNumberException(){
        if(this.numbers.distinct()!=this.numbers) throw IllegalArgumentException(LOTTO_DUPLICATE_NUMBER_ERROR_MESSAGE)
    }

    companion object{
        const val LOTTO_NUMBER_COUNT=6
        const val MIN_NUMBER=1
        const val MAX_NUMBER=45
        const val LOTTO_NUMBER_COUNT_ERROR_MESSAGE ="[ERROR] 로또 번호의 개수는 6이어야 합니다."
        const val LOTTO_NUMBER_RANGE_ERROR_MESSAGE ="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val LOTTO_DUPLICATE_NUMBER_ERROR_MESSAGE ="[ERROR] 로또 번호는 중복되지 않아야 합니다."
    }
}
