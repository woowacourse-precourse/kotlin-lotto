package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoResult.*
import kotlin.math.roundToInt

fun main() {
    val purchasePrice = getPurchasePrice()
    val purchasedLotto = mutableListOf<Lotto>()

    for (i in 0 until purchasePrice / 1000) {
        purchasedLotto.add(generateLottoNumber())
    }

    println("${purchasePrice / 1000}개를 구매했습니다.")
    purchasedLotto.forEach {
        println(it)
    }

    val prizeLotto = getPrizeNumbers()
    val bonusNumber = getBonusNumber()

    fun computeResult(purchasedLotto: Lotto, resultTable: MutableMap<LottoResult, Int>) {
        val lottoResult = prizeLotto.computeResult(purchasedLotto, bonusNumber)
        resultTable[lottoResult] = resultTable[lottoResult]?.plus(1) ?: 1
    }

    val resultTable = mutableMapOf<LottoResult, Int>().apply {
        values().forEach { result ->
            this[result] = 0
        }
    }

    purchasedLotto.forEach {
        computeResult(it, resultTable)
    }

    printResult(resultTable, purchasePrice)
}

fun printResult(resultTable: MutableMap<LottoResult, Int>, purchasePrice: Int) {
    println("당첨 통계")
    println("---")
    values().forEach {
        if (it != ElseMatch) {
            println("${it.prefix} 일치 (${priceFormat(it.price)}) - ${resultTable[it]}개")
        }
    }
    val totalPrice = resultTable.map {
        it.key.price * it.value
    }.sum()
    val priceRatio = ((totalPrice * 100f) / purchasePrice * 10.0).roundToInt() / 10.0
    println("총 수익률은 ${priceRatio}%입니다.")
}

fun priceFormat(price: Int): String =
    "${
        price
            .toString()
            .reversed()
            .chunked(3)
            .reversed().joinToString(",") { it.reversed() }
    }원"


fun getPurchasePrice(): Int {
    println("구입금액을 입력해 주세요.")

    return Console.readLine().toInt()
}

fun getPrizeNumbers(): Lotto {
    println("당첨 번호를 입력해 주세요.")
    val numbers = Console.readLine().split(",").map { it.toInt() }
    return Lotto(numbers)
}

fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine().toInt()
}

fun generateLottoNumber(): Lotto {
    val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    return Lotto(lottoNumbers)
}