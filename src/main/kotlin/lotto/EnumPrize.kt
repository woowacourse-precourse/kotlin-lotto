package lotto

import java.text.DecimalFormat

interface EnumPrizeInterface {
    fun checkPrizeType(prizeType: EnumPrizeType, count: Int): String
}

enum class EnumPrizeType(val price: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000)
}

class EnumPrize() : EnumPrizeInterface {
    override fun checkPrizeType(prizeType: EnumPrizeType, count: Int): String {
        return when (prizeType) {
            EnumPrizeType.FIRST -> "6개 일치 (${priceFormat(EnumPrizeType.FIRST.price)}원) - ${count}개"
            EnumPrizeType.SECOND -> "5개 일치, 보너스 볼 일치 (${priceFormat(EnumPrizeType.SECOND.price)}원) - ${count}개"
            EnumPrizeType.THIRD -> "5개 일치 (${priceFormat(EnumPrizeType.THIRD.price)}원) - ${count}개"
            EnumPrizeType.FOURTH -> "4개 일치 (${priceFormat(EnumPrizeType.FOURTH.price)}원) - ${count}개"
            EnumPrizeType.FIFTH -> "3개 일치 (${priceFormat(EnumPrizeType.FIFTH.price)}원) - ${count}개"
        }
    }

    private fun priceFormat(price: Int): String {
        return DecimalFormat("###,###").format(price)
    }
}