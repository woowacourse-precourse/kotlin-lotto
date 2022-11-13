package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoResult.*
import kotlin.math.roundToInt

fun main() {
    try {
        val purchasePrice = getPurchasePrice()
        val purchasedLotto = getPurchasedLotto(purchasePrice)

        val prizeLotto = getPrizeNumbers()
        val bonusNumber = getBonusNumber()

        val resultTable = mutableMapOf<LottoResult, Int>().apply {
            values().forEach { result ->
                this[result] = 0
            }
        }

        purchasedLotto.forEach {
            computeResult(it, prizeLotto, bonusNumber, resultTable)
        }

        printResult(resultTable, purchasePrice)
    } catch (e: java.lang.IllegalArgumentException) {
        println(e.message)
    }
}

fun computeResult(
    purchasedLotto: Lotto,
    prizeLotto: Lotto,
    bonusNumber: Int,
    resultTable: MutableMap<LottoResult, Int>
) {
    val lottoResult = prizeLotto.computeResult(purchasedLotto, bonusNumber)
    resultTable[lottoResult] = resultTable[lottoResult]?.plus(1) ?: 1
}

fun printResult(resultTable: MutableMap<LottoResult, Int>, purchasePrice: Int) {
    println("당첨 통계")
    println("---")
    values().forEach {
        if (it != ElseMatch) {
            println("${it.prefix} 일치 (${getPriceFormat(it.price)}) - ${resultTable[it]}개")
        }
    }
    val totalPrice = resultTable.map {
        it.key.price * it.value
    }.sum()
    val priceRatio = ((totalPrice * 100f) / purchasePrice * 10.0).roundToInt() / 10.0
    println("총 수익률은 ${priceRatio}%입니다.")
}

fun getPriceFormat(price: Int): String =
    "${
        price
            .toString()
            .reversed()
            .chunked(3)
            .reversed().joinToString(",") { it.reversed() }
    }원"

fun getPurchasedLotto(purchasePrice: Int): List<Lotto> {
    val purchasedLotto = mutableListOf<Lotto>()

    for (i in 0 until purchasePrice / 1000) {
        purchasedLotto.add(generateLottoNumber())
    }

    println("${purchasePrice / 1000}개를 구매했습니다.")
    purchasedLotto.forEach {
        println(it)
    }

    return purchasedLotto
}

fun getPurchasePrice(): Int {
    println("구입금액을 입력해 주세요.")
    val purchasePrice = Console.readLine()

    testPurchasePriceError(purchasePrice)
    return purchasePrice.toInt()
}

fun testPurchasePriceError(purchasePrice: String) {
    val purchasePriceRegex = Regex("\\d+000")
    if (purchasePriceRegex.matches(purchasePrice).not()) {
        throw IllegalArgumentException("[ERROR] 구입금액은 1000 단위 자연수여야 합니다.")
    }
}

fun getPrizeNumbers(): Lotto {
    println("당첨 번호를 입력해 주세요.")
    val numbers = Console.readLine()
    testPrizeNumberError(numbers)

    return Lotto(numbers.split(",").map { it.toInt() })
}

fun testPrizeNumberError(prizeNumbers: String) {
    val formatRegex = Regex("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+")
    val numberRegex = Regex("\\d+")

    if (formatRegex.matches(prizeNumbers).not()) {
        throw java.lang.IllegalArgumentException("[ERROR] 당첨 번호 입력 형태가 잘못되었습니다.")
    }

    numberRegex.findAll(prizeNumbers).forEach {
        testNumberRangeError(it.value.toInt())
    }
}

fun testNumberRangeError(number: Int) {
    if ((number in (1..45)).not()) {
        throw java.lang.IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine()
    testBonusNumberError(bonusNumber)

    return bonusNumber.toInt()
}

fun testBonusNumberError(bonusNumber: String) {
    val numberRegex = Regex("\\d+")
    if (numberRegex.matches(bonusNumber).not()) {
        throw java.lang.IllegalArgumentException("[ERROR] 보너스 숫자 형태가 잘못되었습니다.")
    }

    testNumberRangeError(bonusNumber.toInt())
}

fun generateLottoNumber(): Lotto {
    val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    return Lotto(lottoNumbers)
}