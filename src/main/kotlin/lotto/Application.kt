package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat
import kotlin.math.round

fun main() {
    val lottoGame = LottoGame()
    lottoGame.playLotto()
}

class LottoManager(){

    private var lottoList = mutableListOf<Lotto>()

    private fun createLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    fun resetLottoList(){
        lottoList.clear()
    }

    fun createLottoList(num:Int){
        for(i in 1..num){
            lottoList.add(createLotto())
        }
    }

    fun getLottoList(): MutableList<Lotto> {
        return lottoList
    }

    override fun toString(): String {
        return "${lottoList.size}개를 구매했습니다.\n" + lottoList.joinToString("\n")
    }

}

enum class Prize(val money:Int, val accuracy:Int, val bonus:Boolean){
    THREE(5000, 3, false),
    FOUR(50000,4,false),
    FIVE(1500000,5,false),
    FIVE_BONUS(30000000,5, true),
    SIX(2000000000 , 6, false);

    override fun toString(): String {
        if(bonus)
            return "${accuracy}개 일치, 보너스 볼 일치 (${DecimalFormat("#,###").format(money)}원)"

        return "${accuracy}개 일치 (${DecimalFormat("#,###").format(money)}원)"
    }







}


class LottoGame(){

    private val numberInput : NumberInput = NumberInput()
    private val lottoManager = LottoManager()

    private val prizeList = mutableListOf<Int>(0,0,0,0,0)


    fun playLotto(){
        println("구입금액을 입력해 주세요.")
        numberInput.inputGameMoney()
        println("")

        lottoManager.createLottoList(numberInput.coin)
        println(lottoManager)

        println("당첨 번호를 입력해 주세요.")
        numberInput.inputWinningNumber()
        println("")

        println("보너스 번호를 입력해 주세요.")
        numberInput.inputBonusNumber()
        println("")

        getPrize()

        println("당첨통계")
        println("---")
        for (i in 0 .. 4){
            println(Prize.values()[i].toString() + " - " + prizeList[i] + "개")
        }

        println("총 수익률은 ${getPercentage()}%입니다.")


    }


    private fun getPrize(){

        val winningMap = mutableMapOf<Int, Int>()
        numberInput.winningNumberList.forEach { winningMap[it] = 1 }

        val bonusNumber = numberInput.bonusNumber

        var score = 0

        lottoManager.getLottoList().map{ it.getNumbers() }.forEach{ lst ->
            score = 0

            lst.forEach{
                score += winningMap[it]?:0
            }

            if(lst.contains(bonusNumber) && score == 5) {
                prizeList[3] += 1
                return@forEach
            }

            when(score){
                3-> prizeList[0] += 1
                4-> prizeList[1] += 1
                5-> prizeList[2] += 1
                6-> prizeList[4] += 1
            }
        }
    }

    private fun getPercentage(): Double {
        var totalPrize : Long = 0
        var percentage : Double = 0.0
        for(i in 0..4){
            totalPrize += Prize.values()[i].money * prizeList[i]
        }
        percentage = (totalPrize.toDouble() / (numberInput.coin * 10))
        return round(percentage*10)/10
    }


}






class NumberInput{

    var coin : Int = 0
    var winningNumberList = listOf<Int>()
    var bonusNumber : Int = 0



    fun inputGameMoney(){
        val moneyInput = Console.readLine()
        val regex = Regex("[0-9]+")

        if(!regex.matches(moneyInput))
            throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요")

        if(moneyInput.toInt() % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 1000의 배수를 입력해주세요")

        this.coin = moneyInput.toInt()/1000


    }

    fun inputWinningNumber() {
        val winningNumberInput = Console.readLine()
        val regex = Regex("([1-9]([0-9]?),){5}[1-9]([0-9]?)")

        if(!regex.matches(winningNumberInput))
            throw IllegalArgumentException("[ERROR] 콤마로 구분된 6개의 숫자를 입력해주세요.")

        val winningNumberList: List<Int> = winningNumberInput.split(",").map{ it.trim().toInt() }

        if(!winningNumberList.all{ it in 1..45 })
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")

        if(winningNumberList.toSet().size != 6)
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 없어야 합니다.")

        this.winningNumberList =  winningNumberList

    }

    fun inputBonusNumber() {
        val bonusNumberInput = Console.readLine()
        val regex = Regex("[1-9]([0-9]?)")

        if(!regex.matches(bonusNumberInput))
            throw IllegalArgumentException("[ERROR] 최대 2자리 숫자여야 합니다.")

        val bonusNumber: Int = bonusNumberInput.toInt()

        if(bonusNumber !in 1..45)
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")

        if(this.winningNumberList.contains(bonusNumber))
            throw IllegalArgumentException("[ERROR] 보너스 숫자는 당첨숫자 6개와 겹치지 말아야 합니다.")


        this.bonusNumber= bonusNumber

    }


}




