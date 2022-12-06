package lotto

import java.text.DecimalFormat

interface EnumPrizeInterface {
    fun checkPrizeType(prizeType: EnumPrizeType, count: Int)
}

enum class EnumPrizeType(val price: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000)
}

class EnumPrize() : EnumPrizeInterface {
    override fun checkPrizeType(prizeType: EnumPrizeType, count: Int) {
        PrintForm().printResultOfLotto(prizeType, count)
    }
}