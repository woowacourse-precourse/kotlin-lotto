package lotto
import camp.nextstep.edu.missionutils.Randoms
import org.mockito.stubbing.Answer

enum class LottoValue(val earning : Int, val correctNumbers : Int, open var amount : Int){
    FIRST(2000000000,6, 0),
    SECOND( 3000000,5, 0),
    THIRD(1500000,5, 0),
    FOURTH(50000,4, 0),
    FIFTH(5000,3, 0)
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

fun lottoBonusNumber(normalNumber: List<Int>) : List<Int>?{
    println("보너스 번호를 입력해 주세요")
    try{
        val bonus = readLine()!!.toInt()
        val bonusNumber = mutableListOf<Int>()
        if (bonus !in 1..45) throw (IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다."))
        if (!normalNumber.contains(bonus)) throw (IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다."))
        bonusNumber.add(bonus)
        return bonusNumber
    } catch (e : NumberFormatException){
        throw (NumberFormatException("[ERROR] 올바르지 않은 보너스 번호입니다."))
    } catch (e : NullPointerException){
        throw (NullPointerException("[ERROR] 값을 입력하지 않았습니다."))
    }
}

fun earningsRatio (payment : Int, earnings : Int) : String {
    try {
        val ratio = String.format("%.2f",(earnings / payment * 1000))!!
        return ratio
    }  catch (e : NullPointerException){
        throw (NullPointerException("[ERROR] 값을 입력하지 않았습니다."))
    }
}

fun lottoCompareNormal(answer: List<Int>, uncheckedLotto : List<Int>) : Int{
    var coincidence = 0
    for (lottoNumber in 0..5){
        if (answer.contains(uncheckedLotto[lottoNumber])){
            coincidence+=1
        }
    }
    return coincidence
}

fun lottoCompareSpecial(special : List<Int>, uncheckedLotto : List<Int>) : Int{
    var specialCoincidence = 0
    if(uncheckedLotto.contains(special[0])){
        specialCoincidence += 1
    }
    return specialCoincidence
}

fun findValue(normalCoincidence : Int, specialCoincidence : Int): MutableList<Int> {
    val prize = mutableListOf<Int>(0,0,0,0,0)
    when(normalCoincidence){
        LottoValue.FIRST.correctNumbers -> prize[4]+=1
        LottoValue.SECOND.correctNumbers -> if (specialCoincidence==1) prize[3]+=1 else prize[2]+=1
        LottoValue.FOURTH.correctNumbers -> prize[1]+=1
        LottoValue.FIFTH.correctNumbers -> prize[0]+=1
    }
    return prize
}

fun calculatePrize(prize : MutableList<Int>){
    when(1){
        prize[0] -> LottoValue.FIFTH.amount+=1
        prize[1] -> LottoValue.FOURTH.amount+=1
        prize[2] -> LottoValue.THIRD.amount+=1
        prize[3] -> LottoValue.SECOND.amount+=1
        prize[4] -> LottoValue.FIRST.amount+=1
    }
}

fun receipt(earningRatio : String){
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - " + LottoValue.FIFTH.amount + "개")
    println("4개 일치 (50,000원) - " + LottoValue.FIFTH.amount + "개")
    println("5개 일치 (1,500,000원) - " + LottoValue.FIFTH.amount + "개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoValue.FIFTH.amount + "개")
    println("6개 일치 (2,000,000,000원) - " + LottoValue.FIFTH.amount + "개")
    println("총 수익률은 " + earningRatio + "입니다.")
}

fun main() {
    TODO("프로그램 구현")
}
