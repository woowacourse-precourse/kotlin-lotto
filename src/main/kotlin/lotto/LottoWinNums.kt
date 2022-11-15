package lotto

import lotto.constants.*

class LottoWinNums(val winNums: List<Int>, val bonusNum: Int) {
    init {
        require(winNums.size == 6) { println(INPUT_WIN_NUM_SIZE_ERROR_MSG) }
        require(bonusNum in 1..45) { println(INPUT_BONUS_NUM_SCOPE_ERROR_MSG) }
        require(winNums.distinct().size == 6) { println(INPUT_WIN_NUM_DUPLICATION_ERROR_MSG) }
        require(winNums.count { it in 1..45 } == 6) { println(INPUT_WIN_NUM_SCOPE_ERROR_MSG) }
        require(!winNums.contains(bonusNum)) { println(INPUT_BONUS_NUM_DUPLICATION_ERROR_MSG) }
    }

}