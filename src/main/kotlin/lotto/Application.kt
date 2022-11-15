package lotto

import camp.nextstep.edu.missionutils.Randoms

fun checkInt(str: String):Boolean {     //입력한 문자열이 숫자로 변환 되는 문자열인지 아닌지 true or false 값을 반환하는 함수
    for (elem in str) {
        if (elem !in '0'..'9') {
            println("[ERROR] 숫자를 입력해주세요.")
            return false
        }
    }
    return true
}

fun randomLotto(): Lotto {       //사용자가 로또를 사면 구매한 로또 번호를 반환하는 함수
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    numbers.sort()

    println(numbers)

    return Lotto(numbers)
}

fun makeLotto(number: String): Int {        //금액을 문자열로 입력받으면 사야하는 로또의 갯수를 알려주는 함수
    var manyLotto = 0
    val num = number.toInt()

    if (num % 1000 != 0)
        throw IllegalArgumentException("[ERROR] 1000단위의 금액을 입력해주세요")

    manyLotto = num / 1000
    println("${manyLotto}개를 구매했습니다.")


    return manyLotto
}

fun getLottoNum(): Lotto {          //입력받은 정답 로또를 반환하는 함수
    val LottoNum = readLine() ?: throw IllegalArgumentException("[ERROR] read null")
    val numlist = LottoNum.split(',')
    val answerlist = mutableListOf<Int>()

    for (n in numlist) {
        if (n.toInt() !in 1..45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        answerlist.add(n.toInt())
    }
    return Lotto(answerlist)
}

fun getBouns(): Int {       //보너스 숫자를 입력받고 숫자가 맞으면 반환하는 함수
    var bouns = 0

    try {
        bouns = readLine()!!.toInt()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 숫자를 입력해주세요.")
    }

    if (bouns !in 1..45)
        throw IllegalArgumentException("[ERROR] 보너스 숫자는 1에서 45 사이의 숫자입니.")

    return bouns
}

fun myLottoScore(
    my: List<Lotto>,
    ans: Lotto,
    bouns: Int
): List<Int> {       //scorelist 의 숫자는 일치한 숫자 갯수, 단 7은 2등! -> 5개 + 보너스
    val scoreList = mutableListOf<Int>()

    for (l in my) {
        scoreList.add(l.lottoCorrect(ans, bouns))
    }

    return scoreList
}

fun calculScore(my: List<Int>){     //내 로또들이 각각 일치하는 갯수를 입력받아 몇 개 일치한 로또가 몇개인지를 계산하는 함수

    for (i in my) {
        when (i) {
            3 -> rank.FIFTH.count++
            4 -> rank.FOURTH.count++
            5 -> rank.THIRD.count++
            7 -> rank.SECOND.count++
            6 -> rank.FIRST.count++
        }
    }
}

fun printScore() {     //결과를 출력해주는 함수
    var idx = 0
    val prize = listOf<rank>(rank.FIFTH, rank.FOURTH, rank.THIRD, rank.SECOND, rank.FIRST)

    for (n in 0 until 5) {
        println("${prize[idx].match} (${prize[idx].prize}원) - ${prize[idx].count}개 ")

        idx++
    }
}

fun calculPrize(): Int {           //받게될 상금을 계산하는 함수
    val prize = listOf(rank.FIFTH, rank.FOURTH, rank.THIRD, rank.SECOND, rank.FIRST)
    var money = 0

    var idx = 0
    for (i in 0 until 5) {
        money += prize[idx].prizeInt * prize[idx].count
        idx++
    }

    return money
}

fun calculrate(my: Int, prize: Int): String {       //내가 산 로또 갯수와 당첨금을 입력받아 수익률을 계산하는 함수
    var temp = ((prize * 10) / my) / 10

    if ((prize * 1000 / my) % 10 >= 5)
        temp++

    val rate = "${temp / 10}.${temp % 10}%"

    return rate
}

enum class rank(val match: String, val prize: String, val prizeInt: Int, var count: Int) {      //등수별 일치 갯수와 당첨금을 포함함 enum클래스
    FIRST("6개 일치", "2,000,000,000", 2000000000, 0),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", 30000000, 0),
    THIRD("5개 일치", "1,500,000", 1500000, 0),
    FOURTH("4개 일치", "50,000", 50000, 0),
    FIFTH("3개 일치", "5,000", 5000, 0)

}

fun main() {
    println("구입금액을 입력해 주세요.")           //구입금액을 입력받고
    val lottoString = readLine()!!
    if(!checkInt(lottoString))
        return

    val numLotto = makeLotto(lottoString)

    val myLotto = mutableListOf<Lotto>()        //입력된 금액에 맞는 로또의 갯수를 생성해서 저장
    for (i: Int in 1..numLotto) {
        myLotto.add(randomLotto())
    }

    println("당첨 번호를 입력해 주세요.")          //당첨 번호를 입력하여 Lotto 클래스 객체를 생성하고
    val answerLotto = getLottoNum()

    println("보너스 번호를 입력해 주세요.")         //보너스 번호도 입력받는다
    val bounsNum = getBouns()

    calculScore(myLottoScore(myLotto, answerLotto, bounsNum))      //내 로또들의 당첨 번호와의 일치 갯수를 구한다


    println("당첨통계")             //로또 번호들이 당첨 번호와 일치하는 숫자에 맞게 결과를 출력한다
    println("---")
    printScore()
    println("총 수익률은 ${calculrate(numLotto, calculPrize())}입니다.")
}