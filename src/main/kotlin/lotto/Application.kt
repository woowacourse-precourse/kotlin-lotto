package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = getMoney()
    val lottoList = makeLottoList(money)
    print(lottoList.toString())
}

fun getMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine().trim()

    if (!ExceptionHandler.checkInputMoney(money)) {
        throw IllegalArgumentException("getMoney()함수 오류 입력받은 값이 숫자가 아니거나 1000원 단위가 아닙니다.")
    }
    return money.toInt()
}

fun makeLotto(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers.sorted())
}

fun makeLottoList(money: Int): List<Lotto> {
    val lottoList = mutableListOf<Lotto>()
    val cnt = money / 1000

    for (i in 1..cnt) {
        lottoList.add(makeLotto())
    }

    return lottoList
}
