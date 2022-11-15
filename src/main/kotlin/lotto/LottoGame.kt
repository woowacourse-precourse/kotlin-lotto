package lotto
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.math.round
import java.text.DecimalFormat
import javax.print.attribute.standard.NumberUp

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
        val profit:Long = (this.winChart[RankAndPrize.FIFTH.index]*RankAndPrize.FIFTH.prize)
                        +(this.winChart[RankAndPrize.FOURTH.index]*RankAndPrize.FOURTH.prize)
                        +(this.winChart[RankAndPrize.THIRD.index]*RankAndPrize.THIRD.prize)
                        +(this.winChart[RankAndPrize.SECOND.index]*RankAndPrize.SECOND.prize)
                        +(this.winChart[RankAndPrize.FIRST.index]*RankAndPrize.FIRST.prize).toLong()
        val profit_:Double = (((profit).toDouble()/this.expenditure)*100)
        return round(profit_*10)/10
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
        try{if(number<RANGE_MIN || number>RANGE_MAX)return doErrorException(ErrorMessage.OUTOFRANGE.message) }
        catch (e:NumberFormatException){}
    }
    private fun checkOverlapping(number: Int,numbers: List<Int>){
        try{if(number in numbers) return doErrorException(ErrorMessage.OVERLAPPING.message) }
        catch (e:NumberFormatException){}
    }
    private fun compareLottosWithWinNumber(){
        var count: Int
        myLotto.forEach{
            count = checkNumber(it.getter())
            if(count>=3) winNumberCount(count,bonusNumber in it.getter())
        }
    }
    private fun countToIndex(rank: Int,bonus: Boolean):RankAndPrize{
        when(rank){
            3 -> return RankAndPrize.FIFTH
            4 -> return RankAndPrize.FOURTH
            5 -> return if(bonus) RankAndPrize.SECOND else RankAndPrize.THIRD
            6 -> return RankAndPrize.FIRST
        }
        return RankAndPrize.OUTOFRANGE
    }
    private fun doErrorException(message: String){
        println(message)
    }
    private fun inputToInt(input: String): Int{
        var temp: Int=0
        try{
            temp = input.toInt()
        }
        catch(e:NumberFormatException){
            println(ErrorMessage.WRONGINPUT.message)
        }
        return temp
    }
    private fun printProfit(){
        val toDecimalForm = DecimalFormat("#,###")
        println("당첨 통계")
        println("---")
        println("3개 일치 (${toDecimalForm.format(RankAndPrize.FIFTH.prize)}원) - ${this.winChart[4]}개")
        println("4개 일치 (${toDecimalForm.format(RankAndPrize.FOURTH.prize)}원) - ${this.winChart[3]}개")
        println("5개 일치 (${toDecimalForm.format(RankAndPrize.THIRD.prize)}원) - ${this.winChart[2]}개")
        println("5개 일치, 보너스 볼 일치 (${toDecimalForm.format(RankAndPrize.SECOND.prize)}원) - ${this.winChart[1]}개")
        println("6개 일치 (${toDecimalForm.format(RankAndPrize.FIRST.prize)}원) - ${this.winChart[0]}개")
        println("총 수익률은 ${calculateProfit()}%입니다.")
    }
    private fun purchaseLotto(){
        println("구입금액을 입력해 주세요.")
        val _input: String = Console.readLine()
        val input: Int = inputToInt(_input)
        val times: Int = input/MONEY_UNIT
        try {
            if(input%MONEY_UNIT!=0) return doErrorException(ErrorMessage.WRONGINPUT.message)
        }
        catch (e: NumberFormatException){}
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
        try{if(this.winNumbers.size!=6) return doErrorException(ErrorMessage.WRONGINPUT.message)}
        catch (e:NumberFormatException){}
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
        val Rank: RankAndPrize = countToIndex(count,flag)
        if(Rank.index!=5){
            winChart[Rank.index]++
        }
    }
    companion object{
        fun start(): LottoGame {
            return LottoGame()
        }
    }
}