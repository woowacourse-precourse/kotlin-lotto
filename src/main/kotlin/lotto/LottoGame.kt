package lotto
import camp.nextstep.edu.missionutils.Console
import kotlin.math.round

class LottoGame private constructor(){
    private val RANGE_MIN = 1
    private val RANGE_MAX =45
    private val MONEY_UNIT=1000

    private var bonusNumber: Int = 0
    private var expenditure: Int = 0

    private val myLotto: MutableList<Lotto> = mutableListOf()
    private val winChart: MutableList<Int> = mutableListOf(0,0,0,0,0)
    private val winNumbers: MutableList<Int> = mutableListOf()

    init{
        this.purchaseLotto()
        this.showMyLotto()
        this.setWinNumbers()
        this.setBonusNumber()
        this.compareLottosWithWinNumber()
        this.printProfit()
    }

    private fun addLotto(){
        this.myLotto.add(Lotto.newLotto())
    }
    private fun calculateProfit(): Double{
        val profit:Int = (this.winChart[4]*5)+(this.winChart[3]*50)+(this.winChart[2]*1500)+(this.winChart[1]*30000)+(this.winChart[0]*2000000)
        val spended:Double = (this.expenditure/MONEY_UNIT).toDouble()
        return round(((profit*100)/spended)*10.0)/10.0
    }
    private fun checkNumber(lotto: List<Int>): Int{
        var count: Int = 0
        var lottoPointer:Int = 0
        var winNumberPointer:Int = 0
        var sameFlag:Int
        while(lottoPointer<6&&winNumberPointer<6){
            sameFlag = lotto[lottoPointer]-this.winNumbers[winNumberPointer]
            if(sameFlag == 0){
                count++
                lottoPointer++
                winNumberPointer++
            }
            if(sameFlag>0)winNumberPointer++
            if(sameFlag<0)lottoPointer++
        }
        return count
    }
    private fun checkNumberRange(number: Int){
        if(number<RANGE_MIN || number>RANGE_MAX){
            throw IllegalArgumentException("[ERROR] 범위를 초과한 입력입니다.")
        }
    }
    private fun checkOverlapping(number: Int,numbers: List<Int>){
        if(number in numbers){
            throw IllegalArgumentException("[ERROR]잘못된 입력입니다.")
        }
    }
    private fun compareLottosWithWinNumber(){
        var count: Int
        myLotto.forEach{
            count = checkNumber(it.getter())
            if(count>=3) winNumberCount(count,bonusNumber in it.getter())
        }
    }
    private fun countToIndex(rank: Int,bonus: Boolean):Int{
        when(rank){
            3 -> return 4
            4 -> return 3
            5 -> return if(bonus) 1 else 2
            6 -> return 0
        }
        return 5
    }
    private fun inputToInt(input: String): Int{
        var temp: Int
        try{
            temp = input.toInt()
        }
        catch(e:java.lang.IllegalArgumentException){
            throw IllegalArgumentException("[ERROR]잘못된 입력입니다.")
        }
        return temp
    }
    private fun printProfit(){
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${this.winChart[4]}개")
        println("4개 일치 (50,000원) - ${this.winChart[3]}개")
        println("5개 일치 (1,500,000원) - ${this.winChart[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${this.winChart[1]}개")
        println("6개 일치 (2,000,000,000원) - ${this.winChart[0]}개")
        println("총 수익률은 ${calculateProfit()}%입니다.")
    }
    private fun purchaseLotto(){
        println("구입금액을 입력해 주세요.")
        val _input: String = Console.readLine()
        val input: Int = inputToInt(_input)
        val times: Int = input/MONEY_UNIT
        if(input%MONEY_UNIT!=0){
            throw IllegalArgumentException("[Error]1000원 단위로 입력해 주세요.")
        }
        for(i in 1..times){
            this.addLotto()
        }
        this.expenditure = input
    }
    private fun setBonusNumber(){
        println("보너스 번호를 입력해 주세요.")
        var input: String = Console.readLine().replace(" ", "")
        this.bonusNumber=inputToInt(input)
        checkNumberRange(this.bonusNumber)
        checkOverlapping(this.bonusNumber,this.winNumbers)
    }
    private fun setWinNumbers(){
        println("당첨 번호를 입력해 주세요.")
        var input: String = Console.readLine().replace(" ","")
        var _input: Int
        input.split(",").forEach{
            _input=inputToInt(it)
            checkNumberRange(_input)
            checkOverlapping(_input,this.winNumbers)
            this.winNumbers.add(_input)
        }
        if(this.winNumbers.size!=6) throw IllegalArgumentException("[ERROR]잘못된 입력입니다.")
        winNumbers.sorted()
    }
    private fun showMyLotto(){
        println("${this.myLotto.size}개를 구매했습니다.")
        if(this.myLotto.isNotEmpty()){
            this.myLotto.forEach{
                println(it.getter())
            }
        }
    }
    private fun winNumberCount(count: Int,flag: Boolean){
        val rankIndex: Int = countToIndex(count,flag)
        if(rankIndex!=5){
            winChart[rankIndex]++
        }
    }
    companion object{
        fun start(): LottoGame {
            return LottoGame()
        }
    }
}