package lotto
import camp.nextstep.edu.missionutils.Randoms

enum class lottoScore(val earning : Int){
    FIRST(2000000000),
    SECOND( 3000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000)
}

fun firstPay() : Int?{
    var pay = 0
    println("구입금액을 입력해 주세요.")
    try {
        pay = readLine()!!.toInt()
        pay/1000 != 0
        return pay
    } catch (e : NumberFormatException){
        println("[ERROR] 입력된 금액이 올바른 금액이 아닙니다.")
    } catch (e : NullPointerException){
        println("[ERROR] 값을 입력하지 않았습니다.")
    }
    return null
}

fun lottoGenerator(amount : Int) : List<Lotto>{
    val lottoBundle = mutableListOf<Lotto>()
    for (lotto in 1..amount){
        val lottoPaper : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottoBundle.add(Lotto(lottoPaper))
    }
    return lottoBundle
}

fun lottoWinningNumber() : List<Int>?{
    println("당첨 번호를 입력해 주세요.")
    try {
        val numbers = readLine()?.split(",")
        val winningNumbers = numbers!!.map { it.toInt() }
        return winningNumbers.toList().sorted()
    } catch (e : NumberFormatException){
        println("[ERROR] 올바르지 않은 당첨 번호입니다.")
    } catch (e : NullPointerException){
        println("[ERROR] 값을 입력하지 않았습니다.")
    }
    return null
}

fun lottoBonusNumber() : List<Int>?{
    println("보너스 번호를 입력해 주세요")
    try{
        val bonus = readLine()!!.toInt()
        val bonusNumber = mutableListOf<Int>()
        bonus in 1..45
        bonusNumber.add(bonus)
        return bonusNumber
    } catch (e : NumberFormatException){
        println("[ERROR] 올바르지 않은 보너스 번호입니다.")
    } catch (e : NullPointerException){
        println("[ERROR] 값을 입력하지 않았습니다.")
    }
    return null
}

fun earningsRatio (payment : Int, earnings : Int) {
    try {
        val ratio = (earnings / payment * 100)!!
        print("총 수익률은 ")
        print(String.format("%.2f",ratio))
        println("입니다.")
    }  catch (e : NullPointerException){
        println("[ERROR] 값을 입력하지 않았습니다.")
    } catch (e : IllegalArgumentException){
        println("[ERROR] 비정상적인 값입니다.")
    }
}


fun main() {
    TODO("프로그램 구현")
}
