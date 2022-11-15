package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.security.cert.TrustAnchor
import java.util.Objects
import kotlin.math.round

class Lotto(private val numbers: List<Int>) {
    private var lottoNumbers = listOf<Int>()
    private var bonusFlag: Boolean = false
    var lotteryresult: Int = 0
    var bonusresult: Boolean = false

    private fun getbonusFlag():Boolean{
        return bonusFlag
    }

    init {
        require(numbers.size == 6)
        this.lottoNumbers = numbers.sorted()
        this.bonusFlag = false
    }

    // TODO: 추가 기능 구현

    override fun toString(): String {
        // function to make class Lotto to String
        // - to print out -
        var string = "["
        this.lottoNumbers
        for (i in 0 until 5){
            string += this.lottoNumbers[i].toString() + ", "
        }

        return string + this.lottoNumbers[5].toString() + "]"
    }


    fun checkLottery(winlottonum : Lotto){
        var lottery: Int = 0

        val winnum = winlottonum.lottoNumbers
        val checknum = this.lottoNumbers

        winnum.forEach() {it
            lottery += compareWithList(checknum, it)
        }
        if (lottery == 5){
            this.bonusFlag = true
        }

        this.lotteryresult = lottery
    }

    fun checkBonus(bonusnum: Int) {
        if(this.bonusFlag) { this.bonusresult = bonusNumCheck(bonusnum) }
    }

    private fun compareWithList(checkList: List<Int>, win: Int): Int{
        if (checkList.contains(win)){
            return 1
        }
        else
            return 0
    }

    private fun bonusNumCheck(bonusnum : Int) : Boolean{
        // checks for bonus number
        val checknum = this.lottoNumbers
        var lottery = compareWithList(checknum, bonusnum)
        return (lottery>=1)
    }


}


fun buyLotto(): List<Lotto>{
    println("구매 금액을 입력해 주세요.")
    var userInput : Int? = readLine()!!.toIntOrNull()
    userInputCheck(userInput)
    userInput = userInput?.div(1000)


    var lottoList = createLottoList(userInput!!)
    println("\n${userInput}개를 구매했습니다.\n")
    printLottos(lottoList)
    return lottoList
}

fun winningNumber(Lottos: List<Lotto>){
    println("당첨 번호를 입력해 주세요.")
    var winstr : List<String> = readLine()!!.split(",")
    var winint : List<Int>   = listOf()
    winstr.forEach() {
        winint += it.toInt()
    }
    winningNumCheck(winint)

    println("\n보너스 번호를 입력해 주세요.")
    var bonus : Int? = readLine()!!.toIntOrNull()
    bonusNumCheck(bonus)
    
    result(Lottos, winint, bonus!!)
}

fun result(lottolist: List<Lotto>, winint: List<Int>, bonus: Int) {
    println("\n당첨 통계\n---")
    lottolist.forEach(){it
        it.checkLottery(Lotto(winint))
        it.checkBonus(bonus)
    }
    var lottos = Lottos(lottolist)
    lottos.printres()
}


fun bonusNumCheck(bonus: Int?) {
    val E = ExceptionExplain.WrongBonusNum

    if (bonus !is Int)
        E.checkAndThrowException()

    checkRangeOfNum(bonus!!)
}

fun winningNumCheck(winint: List<Int>) {
    val E = ExceptionExplain.WrongWinNum

    if (winint !is List<Int>)
        E.checkAndThrowException()

    winint.forEach(){
        checkRangeOfNum(it)
    }
}

fun checkRangeOfNum(it: Int) {
    val E = ExceptionExplain.WrongWinNum

    if (it >45 || it<1)
        E.checkAndThrowException()
}

fun printLottos(lottoList: List<Lotto>){
    lottoList.forEach(){
        println(it.toString())
    }
}

fun userInputCheck(userInput: Int?){
    val E = ExceptionExplain.WrongPayment

    if (userInput !is Int)
        E.checkAndThrowException()
    if (1 > userInput!!)
        E.checkAndThrowException()

}

fun createOneLotto() : Lotto {
    // 새로운 랜덤한 로또 용지 하나를 만드는 함수

    var newLotto = mutableSetOf<Int>()
    while (newLotto.size < 6)
        newLotto+= Randoms.pickNumberInRange(1, 45)
    return ListToLotto(newLotto.toList())
}

fun ListToLotto(lottoInList: List<Int>) : Lotto {
    return Lotto(lottoInList)
}

fun createLottoList(howMany : Int) : List<Lotto> {
    // 로또 용지의 전체 리스트를 리턴함
    var newLottoList: List<Lotto> = listOf()

    for (i: Int in 0 until howMany) {
        val aLotto = createOneLotto()
        newLottoList += aLotto
    }
    return newLottoList
}

enum class ExceptionExplain{
    WrongPayment{
        override fun checkAndThrowException() { throw IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위의 정수입니다.") }
    }, WrongWinNum{
        override fun checkAndThrowException() { throw IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하입니다.") }
    }, WrongBonusNum{
        override fun checkAndThrowException() { throw IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하입니다.") }
    };
    abstract fun checkAndThrowException()
}

class Lottos(private val lottos: List<Lotto>){
    var lottoslist : List<Lotto> = this.lottos

    private fun calculate(i: Int, lottos: List<Lotto>): Int{
        var cnt = 0
        lottos.forEach(){ if(it.lotteryresult == i) cnt += 1}
        if (i == 5) return cnt - calcBonus(lottos)

        return cnt
    }

    private fun calcBonus(lottos: List<Lotto>): Int {
        var cnt = 0
        lottos.forEach(){ if(it.bonusresult) cnt += cnt}
        return cnt
    }

    private var cntThree = calculate(3, lottos)
    private var cntFour = calculate(4,lottos)
    private var cntFive = calculate(5, lottos)
    private var cntBonus = calcBonus(lottos)
    private var cntSix = calculate(6, lottos)

    private var totalres = cntThree*5 + cntFour* 50 + cntFive*1500 + cntBonus*30000 + cntSix*2000000

    private var earned :Float = (totalres.toFloat() / lottos.size.toFloat())

    fun printres(){
        println("3개 일치 (5,000원) - ${this.cntThree}개")
        println("4개 일치 (50,000원) - ${this.cntFour}개")
        println("5개 일치 (1,500,000원) - ${this.cntFive}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${this.cntBonus}개")
        println("6개 일치 (2,000,000,000원) - ${this.cntSix}개")
        println("총 수익률은 ${round(this.earned*10)/10}% 입니다.")
    }

}