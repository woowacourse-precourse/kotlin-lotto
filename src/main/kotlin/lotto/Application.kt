package lotto

fun main() {
    val count : Int
    val money : Int
    val lottoCollection : MutableList<List<Int>>
    val winningNumber : MutableList<Int>
    val bonusNumber : Int
    val winnedLotto = mutableListOf<Int>()
    val fs = functionSet()

    val grade1 : Int
    val grade2 : Int
    val grade3 : Int
    val grade4 : Int
    val grade5 : Int
    val earnings : Double

    // 구매 금액 입력
    println(sendMessage.messageMoney.message)
    money = fs.inputMoney()
    println(money)
    println()

    // 개수 산출
    count = fs.outputCount(money)
    println(count.toString() + sendMessage.messageCount.message)

    // 개수만큼 로또번호 셍성
    lottoCollection = fs.outputLotto(count)
    for (lotto in lottoCollection) {
        println(lotto)
    }
    println()

    // 로또번호 입력
    println(sendMessage.messageNumber.message)
    winningNumber = fs.inputNumber()
    println(winningNumber.toString())
    println()
    println(sendMessage.messageBonus.message)
    bonusNumber = fs.inputbonus()
    println(bonusNumber)
    println()

    // 예외 검출
    Lotto(winningNumber)

    // 당첨 판정
    for (i in lottoCollection) {
        winnedLotto.add(fs.compareNumbers(i,winningNumber, bonusNumber))
    }

    // 결과 출력
    grade1 = winnedLotto.count{it == 6}
    grade2 = winnedLotto.count{it == 7}
    grade3 = winnedLotto.count{it == 5}
    grade4 = winnedLotto.count{it == 4}
    grade5 = winnedLotto.count{it == 3}

    earnings = ((grade1*2000000000+grade2*30000000+grade3*1500000+grade4*50000+grade5*5000) * 10000 / money ) / 100.0

    println(sendMessage.messageResult.message)
    println("---")
    println(sendMessage.grade5.message+grade5+"개")
    println(sendMessage.grade4.message+grade4+"개")
    println(sendMessage.grade3.message+grade3+"개")
    println(sendMessage.grade2.message+grade2+"개")
    println(sendMessage.grade1.message+grade1+"개")
    println(sendMessage.messageEarning.message+earnings+"%입니다.")
}
