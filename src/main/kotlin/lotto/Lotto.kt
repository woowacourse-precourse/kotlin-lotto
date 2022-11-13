package lotto

import utils.Messages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun checkinputAnswer(): Boolean {
        if (!numbers.toString().contains(",")) throw IllegalArgumentException(Messages.ERROR_PREFIX_MESSAGE + Messages.ERROR_ANSWER_COMMA)
        if (numbers.toString().length != 11) throw IllegalArgumentException(Messages.ERROR_PREFIX_MESSAGE + Messages.ERROR_ANSWER_SIX)
        // 같은 숫자가 있는 지 체크하는 로직 추가되어야
        return true
    }

}