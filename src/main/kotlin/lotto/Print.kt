package lotto

import camp.nextstep.edu.missionutils.Console

class Print {
	fun andInput(order: String): String {
		val postposition = when (order) {
			Enum.UserInputWord.BUY_PRICE.order -> Enum.Strings.POSTPOSITION_TYPE1.value
			Enum.UserInputWord.WINNING_NUMBER.order, Enum.UserInputWord.BONUS_NUMBER.order -> Enum.Strings.POSTPOSITION_TYPE2.value
			else -> throw IllegalArgumentException(Enum.Error.INAPPROPRIATE_ORDER.words)
		}
		println("$order$postposition${Enum.UserInputWord.PLEASE_ENTER.order}")
		return Console.readLine()
	}

	fun lottoNumbers(lottoList: List<Lotto>, price: Long) {
		val time = price / Enum.Price.UNIT.value
		println("${time}개를 구매했습니다.")
		for (lotto in lottoList) {
			println(lotto.getNumbers().sorted())
		}
	}

	fun winningByRank(countWinnings: Map<Int, Int?>) {
		val totalReturn = mutableMapOf<Int, Int?>()
		for (key in Enum.Index.WINNING_COUNT_ZERO.value..Enum.Index.WINNING_COUNT_FOUR.value)
			totalReturn[key] = Enum.Index.WINNING_COUNT_ZERO.value
		for (countWinning in countWinnings) {
			if (countWinning.value != null)
				totalReturn[countWinning.key - Enum.Index.WINNING_COUNT_MEDIATOR.value] = countWinning.value
		}
		println(Enum.Print.RATE)
		switchSecondAndFirst(totalReturn)
		val countPrints = listOf(
			Enum.Print.CORRECT_THREE.words,
			Enum.Print.CORRECT_FOUR.words,
			Enum.Print.CORRECT_FIVE.words,
			Enum.Print.CORRECT_BONUS.words,
			Enum.Print.CORRECT_SIX.words
		)
		for (index in countPrints.indices) {
			println("${countPrints[index]}${totalReturn[index]}${Enum.Print.UNIT.words}")
		}
	}

	private fun switchSecondAndFirst(totalReturn: MutableMap<Int, Int?>) {
		val temp = totalReturn[Enum.Index.WINNING_COUNT_SECOND.value]
		totalReturn[Enum.Index.WINNING_COUNT_SECOND.value] = totalReturn[Enum.Index.WINNING_COUNT_FIRST.value]
		totalReturn[Enum.Index.WINNING_COUNT_FIRST.value] = temp
	}

	fun rateOfReturn(rate: String) {
		println("${Enum.Print.TOTAL.words}$rate${Enum.Print.IS_PERCENT.words}")
	}
}