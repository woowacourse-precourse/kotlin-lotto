package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val price = inputBuyLottoPrice()
    val savedLottoNumbers = ArrayList<List<Int>>()
    for (i in 0 until price / 1000) {
        createLottoNumber(savedLottoNumbers)
    }
    val winningNumbers = inputLottoWinningNumebers()
    val bonusNumber = inputBonusNumber(winningNumbers)

    val lotto = Lotto(winningNumbers.map { it.toInt() })

    val winningResult = compareNumbers(lotto, savedLottoNumbers, bonusNumber)
    printWinningResult(winningResult)

    println("총 수익률은 ${String.format("%.1f", calcProfitRate(price, winningResult))}%입니다.")
}

fun calcProfitRate(price: Int, winningResult: MutableList<Int>): Double {
    var profitPrice: Double = 0.0
    profitPrice += winningResult[0] * 5000
    profitPrice += winningResult[1] * 50000
    profitPrice += winningResult[2] * 1500000
    profitPrice += winningResult[3] * 30000000
    profitPrice += winningResult[4] * 2000000000

    return (profitPrice / price) * 100
}

fun printWinningResult(winningResult: MutableList<Int>) {
    println("\n당첨 통계\n---")
    println("3개 일치 (5,000원) - ${winningResult[0]}개")
    println("4개 일치 (50,000원) - ${winningResult[1]}개")
    println("5개 일치 (1,500,000원) - ${winningResult[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult[3]}개")
    println("6개 일치 (2,000,000,000원) - ${winningResult[4]}개")
}

fun compareNumbers(lotto: Lotto, savedLottoNumbers: ArrayList<List<Int>>, bonusNumber: Int): MutableList<Int> {
    val winningCount = MutableList<Int>(5) { 0 }
    for (i in savedLottoNumbers) {
        when (lotto.compareLottoNumbers(i)) {
            Rank.ZERO, Rank.ONE, Rank.TWO,Rank.ERROR -> null
            Rank.THREE -> winningCount[0]++
            Rank.FOUR -> winningCount[1]++
            Rank.FIVE -> {
                if (!i.contains(bonusNumber)) {
                    winningCount[2]++
                } else {
                    winningCount[3]
                }
            }

            Rank.SIX -> winningCount[4]++
        }
    }
    return winningCount
}

fun inputBonusNumber(winningNumbers: List<String>): Int {
    println("\n보너스 번호를 입력해 주세요.")
    try {
        val bonusNumber = readLine().toString().toInt()
        if (bonusNumber < 1 || bonusNumber > 45) {
            printException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
        } else if (winningNumbers.contains(bonusNumber.toString())) {
            printException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.")
        }
        return bonusNumber
    } catch (e: NumberFormatException) {
        printException("[ERROR] 숫자를 입력해주세요.")
    }
    throw IllegalArgumentException()
}

fun inputLottoWinningNumebers(): List<String> {
    println("\n당첨 번호를 입력해 주세요.")
    val winninngNumbers = readLine().toString().split(",")

    if (winninngNumbers.distinct().size != 6) {
        printException("[ERROR] 6개의 중복되지 않은 숫자를 입력해주세요.")
    }
    for (number in winninngNumbers) {
        if (number.toInt() < 1 || number.toInt() > 45) {
            printException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
        }
    }
    return winninngNumbers
}

fun createLottoNumber(savedLottoNumbers: ArrayList<List<Int>>) {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    savedLottoNumbers.add(numbers)

    Lotto(numbers).printLottoNumbers()
}

fun inputBuyLottoPrice(): Int {
    println("로또 구입금액을 입력해 주세요.")
    try {
        val price = readLine().toString().toInt()
        if (price % 1000 != 0) {
            printException("[ERROR] 구입 금액은 1,000원 단위입니다.")
        }
        println("\n${price / 1000}개를 구매했습니다.")

        return price
    } catch (e: NumberFormatException) {
        printException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
    }
    return 0
}

fun printException(message: String) {
    println(message)
    throw IllegalArgumentException()
}