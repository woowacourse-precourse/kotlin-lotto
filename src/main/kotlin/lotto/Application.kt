package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
	val price = Print().andInput("구입금액")
	if (!UserInputValid().buyPrice(price))
		throw IllegalArgumentException(Enum.Error.INVALID_NUMBER.words)
	val lottos = issueLotto(price.toLong())
	println()
	Print().lottoNumbers(lottos, price.toLong())
	println()
	val numbersWithComma = Print().andInput("당첨 번호")
	if (!UserInputValid().winningNumbers(numbersWithComma))
		throw IllegalArgumentException(Enum.Error.INVALID_NUMBER.words)
	println()
	val number = Print().andInput("보너스 번호")
	if (!UserInputValid().bonusNumber(number))
		throw IllegalArgumentException(Enum.Error.INVALID_NUMBER.words)
	println()
	mainCalculateAndPrintResult(numbersWithComma, lottos, price, number)
}

fun mainCalculateAndPrintResult(numbersWithComma: String, lottos: List<Lotto>, price: String, number: String) {
	val numbersWithCommaToIntList = numbersWithComma.split(',').map { it.toInt() }
	val calculateWinnings = Calculate().winningByLotto(lottos, listOf(numbersWithCommaToIntList, listOf(number.toInt())))
	val countWinnings = countWinningByRank(calculateWinnings)
	val rate = Calculate().rateOfReturn(countWinnings, price.toLong())

	Print().winningByRank(countWinnings)
	Print().rateOfReturn(rate)
}

fun countWinningByRank(calculateWinnings: List<Int>): Map<Int, Int?> {
	val countWinnings = mutableMapOf<Int, Int?>()
	for (key in Enum.Rank.MIN.value..Enum.Rank.MAX.value)
		countWinnings[key] = Enum.Rank.INIT.value
	for (calculateWinning in calculateWinnings) {
		countWinnings[calculateWinning] = countWinnings[calculateWinning]?.plus(Enum.Rank.COUNT.value)
	}
	return countWinnings.toMap()
}

fun issueLotto(price: Long): List<Lotto> {
	val lottoList = mutableListOf<Lotto>()
	var time = price / Enum.Price.UNIT.value
	while (time > Enum.Price.LONG_ZERO.value) {
		val numbers = Randoms.pickUniqueNumbersInRange(
			Enum.LottoNumber.MIN.value,
			Enum.LottoNumber.MAX.value,
			Enum.LottoNumber.QUANTITY.value
		)
		lottoList.add(Lotto(numbers))
		time--
	}
	return lottoList
}
