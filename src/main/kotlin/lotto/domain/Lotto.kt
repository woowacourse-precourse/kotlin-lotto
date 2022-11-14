package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumberCount()
        checkLottoNumberDuplicated()
        for (number in numbers) {
            checkLottoNumberRange(number)
        }
    }
    fun returnLottoNumbers(): List<Int> {
        return numbers
    }
    private fun checkLottoNumberCount(){
        try {
            require(numbers.size == CONSTANT.LOTTO.LOTTO_COUNT.params)
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.LOTTONUMBERCONUTERROR.message)
            throw e
        }
    }
    private fun checkLottoNumberDuplicated(){
        try {
            require(numbers.distinct().size == CONSTANT.LOTTO.LOTTO_COUNT.params)
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.LOTTONUMBERDUPLICATEDERROR.message)
            throw e
        }
    }
    private fun checkLottoNumberRange(number: Int){
        try{
            require(number in CONSTANT.LOTTO.MIN_LOTTO_NUMBER.params..CONSTANT.LOTTO.MAX_LOTTO_NUMBER.params)
        }catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.LOTTONUMBERRANGEERROR.message)
            throw e
        }
    }
}