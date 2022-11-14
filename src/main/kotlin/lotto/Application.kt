package lotto

//함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
//함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
//else를 지양한다.
//힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
//때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
//Enum 클래스를 적용해 프로그래밍을 구현한다.

//핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
//도메인은 Lotto, UI는 이걸로

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

enum class inputMessage(val message: String) {
    messageMoney("구입금액을 입력해 주세요."),
    messageNumber("당첨 번호를 입력해 주세요."),
    messageBonus("보너스 번호를 입력해 주세요.");
}

enum class outputMes(val message: String) {
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
    val money = readLine().toInt()
    return money
}

fun outputCount(money : Int): Int { // 갯수 구하기 예외처리
    val count = money / 1000
    if (money % 1000 != 0) {
        println("[ERROR] : 숫자가 45를 초과했습니다.")
        throw IllegalArgumentException()
    }
    return count
}

fun outputLotto(count: Int): MutableList<List<Int>> {
    val lotto = mutableListOf<List<Int>>()
    var lottoNumber = mutableListOf<Int>()
    for (i in 0 until count) {
        lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lotto.add(lottoNumber)
    }
    return lotto
}

fun main() {
    var count = 0
    var money = 0
    var lottoCollection = mutableListOf<List<Int>>()

    // 구매 금액 입력
    println(inputMessage.messageMoney.message)
    money = inputMoney()
    println(money)
    println()
    // 갯수 산출, 1000으로 안나뉠시 예외처리
    count = outputCount(money)
    println(count.toString() + outputMes.messageCount.message)
    // 갯수만큼 로또번호 셍성
    lottoCollection = outputLotto(count)
    for (lotto in lottoCollection) {
        println(lotto)
    }
}
