package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun makeLotto(): Lotto = try {
    Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
} catch (e: IllegalArgumentException) {
    makeLotto()
}

fun getLottoList(money: Int): List<Lotto> {
    val lottoList = mutableListOf<Lotto>()
    for (i in 0 until (money/1000)) {
        lottoList.add(makeLotto())
    }
    return lottoList
}
fun printAndThrowIllegalException(errorMessage: String) {
    print(errorMessage)
    throw IllegalArgumentException(errorMessage)
}

fun String.checkMoneyCheck(): Int {
    try {
        val result = this.toInt()
        if (result % 1000 != 0) {
            printAndThrowIllegalException("[ERROR] 구입 금액을 잘못입력하셨습니다.")
        }
        return result
    } catch (e: NumberFormatException) {
        printAndThrowIllegalException("[ERROR] 구입 금액을 잘못입력하셨습니다.")
    }
}