package lotto

class Bonus {

    val bonus : Int

    constructor(bonus : String?)  {

        require(bonus != null) { println(NUM_NULL_ERROR_MSG) }
        require(bonus.matches(Regex("\\d+"))) { println(NUM_VALUE_ERROR_MSG) }
        require(bonus.toInt() >= MIN_NUM_LOTTO && bonus.toInt() <= MAX_NUM_LOTTO) { println(NUM_RANGE_ERROR_MSG) }
        this.bonus = bonus.toInt()
    }


    companion object {
        const val MIN_NUM_LOTTO = 1
        const val MAX_NUM_LOTTO = 45
        const val NUM_RANGE_ERROR_MSG = "[ERROR] 보너스 숫자는 1에서 45사이여야 합니다."
        const val NUM_VALUE_ERROR_MSG = "[ERROR] 보너스 숫자는 숫자로만 이루어져야 합니다."
        const val NUM_NULL_ERROR_MSG = "[ERROR] 보너스 숫자가 입력되지 않았습니다"
    }
}