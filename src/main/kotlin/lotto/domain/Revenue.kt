package lotto.domain

class Revenue {

    fun getRevenue(rankResult: MutableMap<Rank, Int>, price: Long): Float{
        var totalRevenue = 0

        totalRevenue += 2000000000 * rankResult[Rank.First]!!
        totalRevenue += 30000000 * rankResult[Rank.Second]!!
        totalRevenue += 1500000 * rankResult[Rank.Third]!!
        totalRevenue += 50000 * rankResult[Rank.Fourth]!!
        totalRevenue += 5000 * rankResult[Rank.Fifth]!!

        return totalRevenue.toFloat() / price.toFloat() * 100

    }
}