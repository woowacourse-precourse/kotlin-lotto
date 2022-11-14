package lotto

import utils.Messages.END_INDEX
import utils.Messages.END_NUM
import utils.Messages.ERROR_ANSWER_DIFFERENT
import utils.Messages.ERROR_ANSWER_SIX
import utils.Messages.ERROR_PREFIX_MESSAGE
import utils.Messages.ERROR_RANGE
import utils.Messages.START_NUM

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == END_INDEX) { ERROR_PREFIX_MESSAGE + ERROR_ANSWER_SIX }
        require(checkinputAnswer())
        numbers.forEach() {
            require(it in START_NUM until END_NUM) { ERROR_PREFIX_MESSAGE + ERROR_RANGE }
        }
    }

    fun checkinputAnswer(): Boolean {
        for (i in numbers) {
            val compareList = numbers - i
            if (compareList.contains(i)) throw IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_ANSWER_DIFFERENT)
        }
        // 같은 숫자가 있는 지 체크하는 로직 추가되어야
        return true
    }

}