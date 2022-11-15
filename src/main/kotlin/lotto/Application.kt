package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val lottoCost = 1000

enum class ErrorMessages(val messages : String){
    MONEY_ERROR("[ERROR] 올바르지 않은 금액입니다."),
    ANSWER_ERROR("[ERROR] 올바르지 않은 당첨 번호입니다."),
    BONUS_ERROR("[ERROR] 올바르지 않은 보너스 번호입니다."),
}

enum class LottoValue(val earning : Int, val correctNumbers : Int, open var amount : Int){
    FIRST(2000000000,6, 0),
    SECOND( 3000000,5, 0),
    THIRD(1500000,5, 0),
    FOURTH(50000,4, 0),
    FIFTH(5000,3, 0)
}

fun firstPay(): Int {
    var deposit = Console.readLine().toString()
    try {
        deposit.toIntOrNull() ?: throw IllegalArgumentException()
        deposit.toInt() % lottoCost != 0
    } catch (e : NumberFormatException){
        throw IllegalArgumentException(ErrorMessages.MONEY_ERROR.messages)
    } catch (e : IllegalArgumentException){
        println(ErrorMessages.MONEY_ERROR.messages)
    }
    return deposit.toInt()
}

fun lottoGenerator(amount : Int) : MutableList<List<Int>>{
    val lottoBundle = mutableListOf<List<Int>>()
    for (lotto in 1..amount){
        val lottoPaper  = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottoBundle.add(Lotto(lottoPaper).lottoNumbers())
    }
    return lottoBundle
}

fun lottoWinningNumber() : List<Int>{
    try {
        val numbers = Console.readLine().split(",")
        val winningNumbers = mutableListOf<Int>()
        for (elements in numbers){
            winningNumbers.add(elements.toInt())
        }
        winningNumbers.distinct().size != 6
        return winningNumbers.toList().sorted()
    } catch (e : IllegalArgumentException){
        throw (IllegalArgumentException(ErrorMessages.ANSWER_ERROR.messages))
    }
}

fun lottoBonusNumber(normalNumber: List<Int>) : List<Int>{
    try{
        val bonus = Console.readLine()?.toIntOrNull() ?: throw (IllegalArgumentException(ErrorMessages.BONUS_ERROR.messages))
        val bonusNumber = mutableListOf<Int>()
        if (bonus !in 1..45) throw (IllegalArgumentException(ErrorMessages.BONUS_ERROR.messages))
        if (normalNumber.contains(bonus)) throw (IllegalArgumentException(ErrorMessages.BONUS_ERROR.messages))
        bonusNumber.add(bonus)
        return bonusNumber
    } catch (e : NumberFormatException){
        throw (IllegalArgumentException(ErrorMessages.BONUS_ERROR.messages))
    }
}



fun lottoCompareNormal(answer: List<Int>, uncheckedLotto :List<Int>) : Int{
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

fun calculateEarns() : Int{
    val earnings = ((LottoValue.FIFTH.amount * LottoValue.FIFTH.earning)+(LottoValue.FOURTH.amount * LottoValue.FOURTH.earning)+(LottoValue.THIRD.amount * LottoValue.THIRD.earning)+(LottoValue.SECOND.amount * LottoValue.SECOND.earning)+(LottoValue.FIRST.amount * LottoValue.FIRST.earning))
    return earnings
}

fun earningsRatio (payment : Int, earnings : Int) : String {
    try {
        return String.format("%.1f", (earnings.toDouble() / payment.toDouble() * 100).toFloat())
    } catch (e: NullPointerException) {
        throw (NullPointerException("[ERROR] 값을 입력하지 않았습니다."))
    }
}

fun receipt(earningRatio : String){
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - " + LottoValue.FIFTH.amount + "개")
    println("4개 일치 (50,000원) - " + LottoValue.FOURTH.amount + "개")
    println("5개 일치 (1,500,000원) - " + LottoValue.THIRD.amount + "개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoValue.SECOND.amount + "개")
    println("6개 일치 (2,000,000,000원) - " + LottoValue.FIRST.amount + "개")
    println("총 수익률은 $earningRatio%입니다.")
}

fun main() {
    try{
        println("구입금액을 입력해 주세요.")
        val paidMoney = firstPay()
        val lottoPapers = paidMoney!! / lottoCost
        println("")

        print(lottoPapers)
        println("개를 구매했습니다.")
        val lottoBundles = lottoGenerator(lottoPapers)
        for (count in 0 until lottoBundles.size){
            println(lottoBundles[count])
        }
        println("")

        println("당첨 번호를 입력해 주세요.")
        val winningNumber = lottoWinningNumber()
        println("")

        println("보너스 번호를 입력해 주세요")
        val bonusNumber = lottoBonusNumber(winningNumber)
        println("")

        for (count in 0 until lottoPapers){
            val normalCoincidence = lottoCompareNormal(winningNumber, lottoBundles[count])
            val specialCoincidence = lottoCompareSpecial(bonusNumber, lottoBundles[count])
            val lottoValues = findValue(normalCoincidence, specialCoincidence)
            calculatePrize(lottoValues)
        }

        val earnedPrize = calculateEarns()
        val ratio = earningsRatio(paidMoney, earnedPrize)

        receipt(ratio)
    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
