package lotto

import camp.nextstep.edu.missionutils.Randoms
import error.InputError
import resource.*

fun main() {
    val purchaseMoney = getPurchaseMoney()
    val numberOfLotto = purchaseMoney / LOTTO_PRICE
    val lottoNumbers = getLottoNumbers(numberOfLotto)
    printLottoNumbers(lottoNumbers)
}

fun printLottoNumbers(numbers: List<Lotto>) {
    println("\n${numbers.size}$PURCHASE_LOTTO")

    for(number in numbers) {
        number.print()
    }
}

fun getLottoNumbers(num: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()

    for(i in 0 until num) {
        lottos.add(Lotto(generateNumbers()))
    }

    return lottos
}

fun generateNumbers(): List<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, Number_OF_LOTTO)
    return numbers.sorted()
}

fun getPurchaseMoney(): Int {
    println(INPUT_MONEY)

    val value = readLine()
    InputError.checkInteger(value)

    val money = value!!.toInt()
    InputError.checkValidMoney(money)

    return money
}
