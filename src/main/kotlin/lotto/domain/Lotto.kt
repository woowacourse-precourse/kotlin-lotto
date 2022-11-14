package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumberCount()
        checkLottoNumberDuplicated()
        for (number in numbers) {
            checkLottoNumberRange(number)
        }
    }
    private fun checkLottoNumberCount(){
        try {
            require(numbers.size == Constant.Lotto.LOTTO_COUNT.params)
        } catch (e: IllegalArgumentException){
            println(Constant.ErrorMessage.CheckLottoNumberCountError.message)
            throw e
        }
    }
    private fun checkLottoNumberDuplicated(){
        try {
            require(numbers.distinct().size == Constant.Lotto.LOTTO_COUNT.params)
        } catch (e: IllegalArgumentException){
            println(Constant.ErrorMessage.CheckLottoNumberDuplicated.message)
            throw e
        }
    }
    private fun checkLottoNumberRange(number: Int){
        try{
            require(number in Constant.Lotto.MIN_LOTTO_NUMBER.params..Constant.Lotto.MAX_LOTTO_NUMBER.params)
        }catch (e: IllegalArgumentException){
            println(Constant.ErrorMessage.CheckLottoNumberRange.message)
            throw e
        }
    }
}