package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import utils.Constants
import utils.Constants.ERROR_MESSAGE_NOT_1000WON
import utils.Constants.ERROR_MESSAGE_OUT_OF_RANGE

class Lotto(private val numbers: List<Int>) {
    private val display = Display()

    init {
        require(numbers.size == 6)
    }

}

