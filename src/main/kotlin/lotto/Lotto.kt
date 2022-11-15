package lotto

import javax.swing.JOptionPane.ERROR_MESSAGE

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(ERROR_MESSAGE.toString() + LottoExecptions.LOTTO_SIZE_ERROR)
        }
        require(checkLottoRange(numbers)) {
            throw IllegalArgumentException(ERROR_MESSAGE.toString() + LottoExecptions.LOTTO_RANGE_ERROR)
        }
        require(checkLottoDuplicated(numbers)) {
            throw IllegalArgumentException(ERROR_MESSAGE.toString() + LottoExecptions.LOTTO_DUPLICATE_ERROR)
        }
    }

    // TODO: 추가 기능 구현

    fun checkLottoRange(numbers: List<Int>): Boolean {
        numbers.forEach {
            if (it in LOTTO_RANGE_START..LOTTO_RANGE_END)
                return true
        }
        return false
    }

    fun checkLottoDuplicated(numbers: List<Int>): Boolean {
        val duplicatedEle = numbers.groupingBy { it }.eachCount().filter { it.value > 1 }
        if (duplicatedEle.isNotEmpty()) {
            return false
        }
        return true
    }

    fun arrangePublishNums(publishNums: List<Int>): List<Int> {
        return publishNums.sorted()
    }

    companion object{
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_RANGE_END = 45
        const val LOTTO_RANGE_START = 1
    }


}
