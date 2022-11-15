package lotto

enum class LottoWinningPlace (
    private val winningMoney : Int,
    private val correctLottoNumCount: Int,
    private val correctBonusNum: Boolean
) {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
}