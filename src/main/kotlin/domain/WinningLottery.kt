package domain

class WinningLottery(private val winningNumbers: List<Int>, private val bonusBall: Int) {

    init {
        require(bonusBall in 1..45) { "보너스볼의 번호는 1~45 사이여야 합니다" }
        require(!winningNumbers.stream().anyMatch { it == bonusBall }) { "당첨번호와 보너스볼에 중복된 번호가 있으면 안됩니다." }
    }

    fun getRank(lottery: Lotto): Rank {
        val winningCount: Int = Lotto(winningNumbers).countSameNumber(lottery)
        return Rank.getRank(winningCount, lottery.contains(bonusBall))
    }
}
