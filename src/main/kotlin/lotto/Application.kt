package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val price = inputBuyLottoPrice()

    for (i in 0 until price / 1000) {
        createLottoNumber()
    }
    val winningNumbers = inputLottoWinningNumebers()
}

fun inputLottoWinningNumebers() {
    println("당첨 번호를 입력해 주세요.")
    val winninngNumbers = readLine().toString().split(",")

    if (winninngNumbers.size != 6) {
        println("[ERROR] 6개의 숫자를 입력해주세요.")
        throw IllegalArgumentException()
    }
    for (number in winninngNumbers) {
        if (number.toInt() < 1 || number.toInt() > 45) {
            println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }
}

fun createLottoNumber() {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    val lotto = Lotto(numbers)

    lotto.printLottoNumbers()
}

fun inputBuyLottoPrice(): Int {
    println("로또 구입금액을 입력해 주세요.")
    val price = readLine().toString()

    try {
        if (price.toInt() % 1000 != 0) {
            println("[ERROR] 구입 금액은 1,000원 단위입니다.")
            throw IllegalArgumentException()
        }
        return price.toInt()
    } catch (e: NumberFormatException) {
        println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}
