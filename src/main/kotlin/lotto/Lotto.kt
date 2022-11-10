package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDuplicated())
    }

    private fun isDuplicated() = numbers.toSet().size != numbers.size
    fun printLotto() {
        numbers.sorted().forEachIndexed { index, i ->
            if (index == 0) print("[$i, ")
            if (index > 0 && index < numbers.size - 1) print("$i, ")
            if (index == numbers.size - 1) println("$i]")
        }
    }

    fun getResult(winningNumber: List<Int>, bonus: Int): LottoResult {
        val winningCount = numbers.reduce { acc, i -> if (winningNumber.contains(i)) acc + 1 else acc }
        if (winningCount == 6) return LottoResult.First
        if (winningCount == 5) {
            if (numbers.contains(bonus)) return LottoResult.Second
            return LottoResult.Third
        }
        if (winningCount == 4) return LottoResult.Fourth
        if (winningCount == 3) return LottoResult.Fifth
        return LottoResult.None
    }
}
