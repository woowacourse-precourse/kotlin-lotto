package lotto

import camp.nextstep.edu.missionutils.Randoms

fun checkInt(str: String){
    for(elem in str){
        if(elem !in '0' .. '9')
            throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요.")
    }
}
fun randomLotto(): Lotto {       //사용자가 로또를 사면 구매한 로또 번호를 반환하는 함수
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    numbers.sort()

    println(numbers)

    return Lotto(numbers)
}

fun makeLotto(): Int {
    val number = readLine()!!
    var manyLotto = 0
    //구입 금액 입력받고 숫자가 아닌 입력이면 오류처리

    checkInt(number)

    val num = number.toInt()

    if (num % 1000 != 0)
        throw IllegalArgumentException("[ERROR] 1000단위의 금액을 입력해주세요")
    else {
        manyLotto = num / 1000
        println("${manyLotto}개를 구매했습니다.")
    }

    return manyLotto
}

fun getLottoNum(): Lotto {          //입력받은 정답 로또를 반환하는 함수
    val LottoNum = readLine()!!
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

fun getBouns(): Int {
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

fun calculScore(my: List<Int>): List<Int> {
    val score = mutableListOf(0, 0, 0, 0, 0)

    for (i in my) {
        when (i) {
            3 -> score[0]++
            4 -> score[1]++
            5 -> score[2]++
            7 -> score[3]++
            6 -> score[4]++
        }
    }
    return score
}

fun printScore(my: List<Int>) {
    var idx = 0
    val prize = listOf<rank>(rank.FIFTH, rank.FOURTH, rank.THIRD, rank.SECOND, rank.FIRST)

    for (n in my) {
        println("${prize[idx].match} (${prize[idx].prize}원) - ${n}개 ")

        idx++
    }
}

fun calculPrize(my: List<Int>): Int {
    val prize = listOf(rank.FIFTH,rank.FOURTH,rank.THIRD,rank.SECOND,rank.FIRST)
    var money = 0

    var idx = 0
    for (i in my) {
        money += prize[idx].prizeInt * i
        idx++
    }

    return money
}

fun calculrate(my: Int, prize: Int): String {
    var temp = ((prize * 10) / my) / 10

    if ((prize * 1000 / my) % 10 >= 5)
        temp++

    val rate = "${temp / 10}.${temp % 10}%"

    return rate
}

enum class rank(val match: String, val prize: String, val prizeInt: Int) {
    FIRST("6개 일치", "2,000,000,000", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", 30000000),
    THIRD("5개 일치", "1,500,000", 1500000),
    FOURTH("4개 일치", "50,000", 50000),
    FIFTH("3개 일치", "5,000", 5000)

}

fun main() {
    println("구입금액을 입력해 주세요.")
    val myLotto = mutableListOf<Lotto>()
    val numLotto = makeLotto()


    for (i: Int in 1..numLotto) {
        myLotto.add(randomLotto())
    }

    println("당첨 번호를 입력해 주세요.")
    val answerLotto = getLottoNum()

    println("보너스 번호를 입력해 주세요.")
    val bounsNum = getBouns()

    val matchLotto = calculScore(myLottoScore(myLotto, answerLotto, bounsNum))


    println("당첨통계")
    println("---")
    printScore(matchLotto)
    println("총 수익률은 ${calculrate(numLotto, calculPrize(matchLotto))}입니다.")
}