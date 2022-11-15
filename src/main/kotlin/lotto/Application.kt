package lotto

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.assertThrows
import java.lang.Math.round
import java.lang.NumberFormatException

fun main() {
    println("구입금액을 입력해 주세요.")
    var input = readLine()!!.toString()
    if (Find_Num(input)) assertThrows<IllegalArgumentException> {"[ERROR] 숫자가 아닙니다."}
    var charge = input.toInt()
    if (charge % 1000 != 0) assertThrows<IllegalArgumentException>{"[ERROR] 숫자가 나누어 떨어지지 않습니다."}
    var count = (charge / 1000).toInt()
    println("${count}개를 구매했습니다.")
    var list : MutableList<List<Int>> = ArrayList()
    for (i in 1..count){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        var lotto = Lotto(numbers)
        lotto.Find_Error()
        lotto.Find_Duplicate()
        list.add(numbers)
        println(numbers)
    }
    println("당첨 번호를 입력해 주세요.")
    var Input = readLine()!!.split(",")
    var ans = ToInt(Input)
    if (ans.size != 6) assertThrows<IllegalArgumentException> {"[ERROR] 6자리가 아닙니다."}
    println("보너스 번호를 입력해 주세요.")
    val bonus = readLine()!!.toInt()
    var stat = mutableListOf<Int>(0, 0, 0, 0, 0, 0)
    for (i in list){
        var cor = Lotto_Cmp(i, ans, bonus)
        stat[Stat(cor)]++
    }
    Print_Result(stat, charge)
}

fun Find_Num(charge : String) : Boolean{
    return try{
        charge.toInt()
        false
    } catch (e : NumberFormatException){
        true
    }
}

fun ToInt(list : List<String>) : List<Int>{
    var res : MutableList<Int> = ArrayList()
    for (i in list){
        res.add(i.toInt())
    }
    return res
}

fun Lotto_Cmp(i : List<Int>, Input : List<Int>, bonus : Int) : List<Int>{
    var count = 0
    var b_count = 0
    for (j in i){
        if (j in Input) count++
    }
    if (bonus in i) b_count++

    return listOf(count, b_count)
}

fun Stat(cor : List<Int>) : Int{
    if (cor[0] < 3) return 0
    else if (cor[0] == 3) return 1
    else if (cor[0] == 4) return 2
    else if (cor[0] == 5 && cor[1] == 1) return 4
    else if (cor[0] == 5) return 3
    else if (cor[0] == 6) return 5
    else return 0
}
fun Print_Result(stat : List<Int>, charge : Int){
    var rate= ((stat[1] * 5000) + (stat[2] * 50000) + (stat[3] * 1500000) + (stat[4] * 30000000) + (stat[5] * 2000000000)).toDouble() / charge
    println("3개 일치 (5,000원) - ${stat[1]}개")
    println("4개 일치 (50,000원) - ${stat[2]}개")
    println("5개 일치 (1,500,000원) - ${stat[3]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${stat[4]}개")
    println("6개 일치 (2,000,000,000원) - ${stat[5]}개")
    println("총 수익률은 ${round(rate * 1000).toDouble() / 10}%입니다.")
}

