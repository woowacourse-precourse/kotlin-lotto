package lotto

//함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
//함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
//else를 지양한다.
//힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
//때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
//Enum 클래스를 적용해 프로그래밍을 구현한다.
//도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
//핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
//도메인은 Lotto, UI는 여기에
//제공된 Lotto 클래스를 활용해 구현해야 한다.

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

enum class inputMessage(val message: String) {
    messageMoney("구입금액을 입력해 주세요."),
    messageNumber("당첨 번호를 입력해 주세요."),
    messageBonus("보너스 번호를 입력해 주세요.");
}

enum class outputMessage(val message: String) {
    messageCount("개를 구매했습니다."),
    messageResult("당첨 통계"),
    three("3개 일치 (5,000원) - 1개"),
    four("4개 일치 (50,000원) - 0개"),
    five("5개 일치 (1,500,000원) - 0개"),
    fiveBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
    six("6개 일치 (2,000,000,000원) - 0개"),
    messageReturn("총 수익률은 62.5%입니다."),
}

fun inputMoney() : Int{ // 돈 입력
    val money = readLine()
    if (money.toIntOrNull() == null) {
        throw IllegalArgumentException("[ERROR] : 잘못된 금액을 입력했습니다.")
    }
    return money.toInt()
}

fun outputCount(money : Int): Int { // 개수 계산
    val count = money / 1000
    if (money % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] : 로또 구매후 잔액이 존재합니다.")
    }
    return count
}

fun outputLotto(count: Int): MutableList<List<Int>> { // 로또 생성
    val lotto = mutableListOf<List<Int>>()
    var lottoNumber = mutableListOf<Int>()
    for (i in 0 until count) {
        lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lotto.add(lottoNumber)
    }
    return lotto
}

fun inputNumber(): String { // 숫자 입력
    val number = readLine()
    return  number
}

fun inputbonus(): Int { // 보너스 입력
    var bonus = readLine().toInt()
    return  bonus
}

//fun inputNumber(): MutableList<Int> { // 숫자 입력
//    val splitNumber = readLine().split(",")
//    val number = mutableListOf<Int>()
//    for (i in splitNumber) {
//        number.add(i.toInt())
//    }
//    return  number
//}

fun main() {
    var count = 0
    var money = 0
    var lottoCollection = mutableListOf<List<Int>>()
    var winningNumber = ""
    var bonusNumber = 0

    // 구매 금액 입력
    println(inputMessage.messageMoney.message)
    money = inputMoney()
    println(money)
    println()

    // 개수 산출
    count = outputCount(money)
    println(count.toString() + outputMessage.messageCount.message)

    // 개수만큼 로또번호 셍성
    lottoCollection = outputLotto(count)
    for (lotto in lottoCollection) {
        println(lotto)
    }
    println()

    // 로또번호 입력
    println(inputMessage.messageNumber.message)
    winningNumber = inputNumber()
    println(winningNumber)
    println()
    println(inputMessage.messageBonus.message)
    bonusNumber = inputbonus()
    println(bonusNumber)
    println()

}
