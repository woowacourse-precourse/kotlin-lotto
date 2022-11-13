package domain

class Lotteries {

    private val randomLotteries = mutableListOf<Lotto>()

    fun setRandomLotteries(lotteriesNumber: List<List<Int>>) {
        lotteriesNumber.forEach { randomLotteries.add(Lotto(it)) }
    }

    fun getRandomLotteries(): List<Lotto> = randomLotteries
}
