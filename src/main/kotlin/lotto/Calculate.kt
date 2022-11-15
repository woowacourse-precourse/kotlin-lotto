package lotto

class Calculate {
	fun winningByLotto(lottoList: List<Lotto>, winningAndBonusNumbers: List<List<Int>>): List<Int> {
		val calculateWinnings = mutableListOf<Int>()
		for (lotto in lottoList) {
			var count = countRepeat(lotto, winningAndBonusNumbers[Enum.Index.WINNING_NUMBERS.value])
			if (count == Enum.Bonus.HAVE_TO_CHECK.value)
				count = checkBonus(lotto, winningAndBonusNumbers[Enum.Index.BONUS_NUMBER.value])
			calculateWinnings.add(count)
		}
		return calculateWinnings
	}

	private fun checkBonus(lotto: Lotto, bonus: List<Int>): Int {
		for (lottoNumber in lotto.getNumbers()) {
			if (bonus[Enum.Bonus.INDEX.value] == lottoNumber)
				return Enum.Bonus.YES.value
		}
		return Enum.Bonus.NO.value
	}

	private fun countRepeat(lotto: Lotto, winningNumbers: List<Int>): Int {
		val checkLotto = winningNumbers.toMutableList()
		checkLotto.addAll(lotto.getNumbers())
		return (lotto.getNumbers().size + winningNumbers.size) - checkLotto.distinct().size
	}

	fun rateOfReturn(countWinnings: Map<Int, Int?>, price: Long): String {
		var totalReturn: Long = 0
		for (countWinning in countWinnings) {
			when (countWinning.key) {
				3 -> totalReturn += countWinning.value?.times(Enum.Rank.FIFTH.value)!!
				4 -> totalReturn += countWinning.value?.times(Enum.Rank.FOURTH.value)!!
				5 -> totalReturn += countWinning.value?.times(Enum.Rank.THIRD.value)!!
				6 -> totalReturn += countWinning.value?.times(Enum.Rank.FIRST.value)!!
				7 -> totalReturn += countWinning.value?.times(Enum.Rank.SECOND.value)!!
			}
		}
		return String.format("%.1f", totalReturn / price.toFloat() * 100)
	}
}