package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var lotto: Lotto
    val price = inputBuyLottoPrice()
    for (i in 0 until price / 1000) {
        createLottoNumber()
    }
    val winningNumbers = inputLottoWinningNumebers()
    val bonusNumber = inputBonusNumber()
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    try {
        val bonusNumber = readLine().toString().toInt()
        if (bonusNumber < 1 || bonusNumber > 45) {
            printException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
        }
        return bonusNumber
    } catch (e: NumberFormatException) {
        printException("[ERROR] 숫자를 입력해주세요.")
    }
    throw IllegalArgumentException()
}

fun inputLottoWinningNumebers(): List<String> {
    println("당첨 번호를 입력해 주세요.")
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
            printException("[ERROR] 구입 금액은 1,000원 단위입니다.")
        }
        return price.toInt()
    } catch (e: NumberFormatException) {
        printException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.")
    }
    throw IllegalArgumentException()
}
fun printException(message: String) {
    println(message)
    throw IllegalArgumentException()
}