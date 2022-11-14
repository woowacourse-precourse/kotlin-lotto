package lotto.data

class WinningTable(
    private val money: Int,
    private val lotteries: List<Lotto>,
    private val winning: WinningLotto,
) {


    data class Record(val info: LottoRank, var count: Int)
}