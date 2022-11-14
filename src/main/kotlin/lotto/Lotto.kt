package lotto

import lotto.constants.MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG
import lotto.constants.MAKE_LOTTO_NUM_SIZE_ERROR_MSG

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){println(MAKE_LOTTO_NUM_SIZE_ERROR_MSG)}
        require(numbers.distinct().size==6){ println(MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG)}
    }
    fun printLottoWinNum(){
        println(numbers.joinToString(", ","[","]"))
    }


}
