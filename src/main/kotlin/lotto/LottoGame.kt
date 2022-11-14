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
    private val winNumbers: MutableList<Int> = mutableListOf()
    init{
        this.purchaseLotto()
        this.showMyLotto()
        this.setWinNumbers()
    }

    private fun addLotto(){
        this.myLotto.add(Lotto.newLotto())
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
    companion object{
        fun start(): LottoGame {
            return LottoGame()
        }
    }
}