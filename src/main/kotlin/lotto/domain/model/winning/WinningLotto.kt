package lotto.domain.model.winning

data class WinningLotto (
    var winningNumbers: List<Int>,
    var bonusNumber: Int
) {
    companion object {
        fun emptyWinningLotto() = WinningLotto(winningNumbers = listOf(), bonusNumber = -1)
    }
}