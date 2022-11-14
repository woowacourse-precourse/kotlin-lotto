package lotto

import lotto.constants.INPUT_BONUS_NUM_ERROR_MSG
import lotto.constants.INPUT_WIN_NUM_SCOPE_ERROR_MSG
import lotto.constants.INPUT_WIN_NUM_SIZE_ERROR_MSG

class LottoWinNums(val winNums: List<Int>,val bonusNum:Int){
    init{
        require(winNums.size==6){println(INPUT_WIN_NUM_SIZE_ERROR_MSG)}
        require(bonusNum in 1..45){println(INPUT_BONUS_NUM_ERROR_MSG)}
        for(num in winNums){
            require(num in 1..45){println(INPUT_WIN_NUM_SCOPE_ERROR_MSG)}
        }
    }

}