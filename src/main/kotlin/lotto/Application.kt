package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchasePrice = getPurchasePrice()
    val purchasedLotto = mutableListOf<Lotto>()

    for (i in 0 until purchasePrice / 1000) {
        purchasedLotto.add(generateLottoNumber())
    }

    println("${purchasePrice / 1000}개를 구매하였습니다")
}

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