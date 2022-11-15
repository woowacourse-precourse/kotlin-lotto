package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.regex.Pattern

fun main() {
    println("구입 금액을 입력해주세요")
    //구입금액
    var money = checkNumber().toInt()
    var lottoNumber = buyLotto(money)
    println("${lottoNumber.size}개를 구매했습니다.")
    for(i in 0 until lottoNumber.size){
        println(lottoNumber[i])
    }
    println("당첨 번호를 입력해 주세요.")
    var winNumber=InputWin()
    println("보너스 번호를 입력해 주세요.")
    var bonus = createBonus(winNumber)
   println("당첨 통계\n" +
           "---")
    var map = compareNumber(lottoNumber, winNumber)
    var result = printResult(map, lottoNumber, bonus)
    printLotto(result)
    println(makeMoney(money, result))
}

fun InputWin(): MutableList<Int> {
    val input = Console.readLine()
    var InputLotto = mutableListOf<Int>()
    var myInput = input.split(",")
    require(myInput.size == 6) {Exception.COUNT.message }
    for (element in myInput){
        require(element.length <=2){
            Exception.RANGE.message
        }
    }
    for (i in 0 until myInput.size){
        InputLotto.add(myInput[i].toInt())
    }
    return InputLotto
}

fun createNumber(): Set<Int> {
    var lottoNumber = HashSet<Int>()

    while (lottoNumber.size < 6) {
        lottoNumber.add(Randoms.pickNumberInRange(1, 45))
    }
    return lottoNumber.toSortedSet()
}


//유저 입력
fun checkNumber(): String {
    val input = Console.readLine()
    val pattern = listOf(Patterns.ZERO, Patterns.CHARACTER, Patterns.BLANK)
    for (nonMoneyPattern in pattern) {
        var matcher = Pattern.compile(nonMoneyPattern.pattern).matcher(input)
        if (matcher.find()) return nonMoneyPattern.pattern
    }
    return input
}


fun createNumber(input: String): Int {
    when (input) {
        Patterns.ZERO.pattern -> Exception.ZERO.message
        Patterns.CHARACTER.pattern -> Exception.CHARACTER.message
        Patterns.BLANK.pattern -> Exception.BLANK.message
    }
    return input.toInt()
}




enum class Patterns(val pattern: String) {
    ZERO("^0+"),
    CHARACTER("\\D+"),
    BLANK("\\s");
}

fun buyLotto(money: Int): List<Set<Int>> {
    var count = money / 1000
    var myLotto = mutableListOf<Set<Int>>()
    repeat(count) {
        createNumber()
        myLotto.add(createNumber())
    }
    return myLotto
}

fun createBonus(winner: List<Int>): Int {
    var input = Console.readLine()
    createNumber(input)
    var bonus = input.toInt()
    require(bonus in 1..45) {
        Exception.RANGE.message
    }

    return bonus
}

///////////비교 부분
fun compareNumber(myLotto: List<Set<Int>>, winner: List<Int>): HashMap<Int, Int> {
    var record = hashMapOf<Int, Int>()
    var win: Int
    for (index in 0 until myLotto.size) {
        var standard = myLotto[index].toHashSet()
        var tmp = standard.union(winner)
        if (tmp.size < 10) {
            win = 12 - tmp.size
            record[index] = win
        }
    }
    return record
}

fun printResult(
    recode: HashMap<Int, Int>,
    myLotto: List<Set<Int>>,
    bonus: Int
): MutableMap<Int, Int> {
    val list = recode.toList()
    val result = mutableMapOf<Int, Int>().apply {
        for (i in 2..6) this[i] = 0
    }
    for (i in list.indices) {
        var compare = list[i].second
        if (compare == 5) checkBonus(myLotto[list[i].first], bonus, result)
        else result[list[i].second] = result.getOrDefault(list[i].second, 0) + 1
    }
    return result
}

fun checkBonus(newRecode: Set<Int>, bonus: Int, result: Map<Int, Int>): Map<Int, Int> {
    if (newRecode.equals(bonus)) {
        result.getOrDefault(2, 0) + 1
        println(newRecode)
        println(bonus)
    } else {
        result.getOrDefault(5, 0) + 1
    }
    return result
}

fun printLotto(result: Map<Int, Int>) {
    for (i in 3..5) {
        when (i) {
            3 -> println("3개 일치 (5,000원) - ${result[3]}개")
            4 -> println("4개 일치 (50,000원) - ${result[4]}개")
            5 -> println("5개 일치 (1,500,000원) - ${result[5]}개")
        }
    }
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[2]}개")
    println("6개 일치 (2,000,000,000원) - ${result[6]}개")
}

fun makeMoney(money: Int, result: Map<Int, Int>): String {
    var lottoMoney = 0.0
    var capital = money.toDouble()// 수익/구입금액
    for (i in 2..6) {
        when (i) {
            2 -> lottoMoney += 30000000 * result[2]!!
            3 -> lottoMoney += 5000 * result[3]!!
            4 -> lottoMoney += 5000 * result[4]!!
            5 -> lottoMoney += 5000 * result[5]!!
            6 -> lottoMoney += 5000 * result[6]!!
        }
    }
    var result = "총 수익률은 " + String.format("%.1f", lottoMoney / capital * 100) + "% 입니다."
    return result
}