package lotto
import camp.nextstep.edu.missionutils.Console
import kotlin.math.round

class LottoGame private constructor(){

    private val MONEY_UNIT=1000

    private var expenditure: Int = 0

    private val myLotto: MutableList<Lotto> = mutableListOf()

    init{
        this.purchaseLotto()
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
    private fun addLotto(){
        this.myLotto.add(Lotto.newLotto())
    }
    companion object{
        fun start(): LottoGame {
            return LottoGame()
        }
    }
}