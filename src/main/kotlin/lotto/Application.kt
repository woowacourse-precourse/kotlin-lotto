package lotto

import camp.nextstep.edu.missionutils.Randoms

fun randomLotto(): Lotto {       //사용자가 로또를 사면 구매한 로또 번호를 반환하는 함수
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    numbers.sort()

    println(numbers)

    return Lotto(numbers)
}

fun makeLotto(): Int {
    var number = 0
    var manyLotto = 0
    //구입 금액 입력받고 숫자가 아닌 입력이면 오류처리
    try {
        number = readLine()!!.toInt()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 숫자를 입력해주세요")
    }

    if (number % 1000 != 0)
        throw IllegalArgumentException("[ERROR] 1000단위의 금액을 입력해주세요")
    else {
        manyLotto = number / 1000
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

fun compareLotto(my: Lotto, ans: Lotto, bouns: Int): Int {
    var count = 0

    for (n in my.lottoNumber) {
        if (ans.lottoNumber.contains(n))
            count++
    }

    if (count == 5) {
        if (my.lottoNumber.contains(bouns))
            count = 7
    }

    return count
}

fun myLottoScore(
    my: List<Lotto>,
    ans: Lotto,
    bouns: Int
): List<Int> {       //scorelist 의 숫자는 일치한 숫자 갯수, 단 7은 2등! -> 5개 + 보너스
    val scoreList = mutableListOf<Int>()

    for (l in my) {
        scoreList.add(compareLotto(l, ans, bouns))
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

fun printScore(my: List<Int>){
    var idx = 0
    var check = 0
    var count = 3
    val prize = listOf("5,000","50,000","1,500,000","30,000,000","2,000,000,000")

    for(n in my){
        if(check == 0)
            println("${count}개 일치 (${prize.get(idx)}원) - ${n}개 ")
        else{
            println("${count}개 일치, 보너스 볼 일치 (${prize.get(idx)}원) - ${n}개 ")
        }
        if(count != 5)
            count++
        else
            check = 1
        idx++
    }
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
}