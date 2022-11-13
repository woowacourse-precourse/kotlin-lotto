package lotto

import utils.Messages.ERROR_ANSWER_DIFFERENT
import utils.Messages.ERROR_PREFIX_MESSAGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun checkinputAnswer(): Boolean {
        for (i in numbers){
            val compareList = numbers - i
            if (compareList.contains(i))
                throw IllegalArgumentException(ERROR_PREFIX_MESSAGE+ERROR_ANSWER_DIFFERENT)
        }
        // 같은 숫자가 있는 지 체크하는 로직 추가되어야
        return true
    }

}