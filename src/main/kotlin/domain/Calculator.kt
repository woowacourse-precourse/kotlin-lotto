package domain

class Calculator {
    fun calculateWinningRate(result: List<Int>, money: Int): Double {
        val sum = Winning.getAllPrize(result)
        val rate = (sum.toDouble() / money.toDouble()) * 100

        return (Math.round(rate * 10)) / 10.0
    }

    fun calculateWinnings(lottos: List<Lotto>, winnings: Lotto, bonus: Int): List<Int> {
        val result = mutableListOf(0, 0, 0, 0, 0)
        for (lotto in lottos) {
            val prize = lotto.calculateWinnings(winnings, bonus)
            if (prize == -1) {
                continue
            }
            result[prize]++
        }

        return result
    }
}