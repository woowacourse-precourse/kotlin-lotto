package lotto.data

class WinningTable(
    private val money: Int,
    private val lotteries: List<Lotto>,
    private val winning: WinningLotto,
) {

    val records: List<Record> = getRecords(lotteries, winning)
    val returnOfRate: Double = calculateReturnOfRate(money, records)

    private fun getRecords(
        lotteries: List<Lotto>,
        winning: WinningLotto
    ): List<Record> {
        return lotteries.groupingBy { winning.matches(it) }
            .eachCount()
            .filterKeys { it.first >= 3 }
            .mapNotNull { Record.newInstance(it.key.first, it.key.second, it.value) }
            .plus(LottoRank.values().map { Record(it, 0) })
            .distinctBy { it.info.rank }
            .sortedDescending()
    }

    private fun calculateReturnOfRate(money: Int, records: List<Record>): Double {
        return records.sumOf { it.info.prize * it.count } / money.toDouble() * 100
    }

    data class Record(val info: LottoRank, var count: Int) : Comparable<Record> {

        override fun compareTo(other: Record): Int {
            return info.rank - other.info.rank
        }

        override fun toString(): String {
            return "$info - ${count}개"
        }

        companion object {

            fun newInstance(hitCount: Int, isBonusHit: Boolean, count: Int): Record? {
                return LottoRank.valueOf(hitCount, isBonusHit)?.let {
                    Record(it, count)
                }
            }
        }
    }
}