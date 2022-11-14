package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


enum class Rank(var match:Int, var prize : Int){
    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000)

}
class GameStart {
    private var money =0
    private var table = listOf<List<Int>>()
    private var ranks = Array(8,{0})
    private var bonusNum = 0
    private fun createLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun publishLotto(money : Int):List<List<Int>>
    {
        var table = mutableListOf<List<Int>>()
        var i :Int = 0
        while (i < (money / 1000)){
            table.add(createLottoNum())
            i++;
        }
        return table
    }
    private fun printLottos(table : List<List<Int>>){
        println("${table.size}개를 구매했습니다.")
        for (i in table)
            println(i)
    }
    private fun inputMoney() : Int{
        println("구입금액을 입력해 주세요.")
        var money = Console.readLine()
        require(money.all{it.isDigit()}){"[ERROR] : 숫자만 입력해야 합니다."}
        require(money.toInt()%1000 == 0){"[ERROR] : 금액은 1000으로 나누어 떨어져야 합니다."}

        return money.toInt()
    }
    private fun inputWinNum() : List<Int> {
        println("당첨 번호를 입력해 주세요.")
        var nums = (Console.readLine().split(","))
        require(nums.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(nums.distinct().size==6){"[ERROR] : 중복된 숫자가 있습니다"}
        require(nums.all{it.all{it.isDigit()}}){"[ERROR] : 숫자만 입력해야 합니다."}
        require(nums.all{it.toInt() in 1..45}){"[ERROR] : 1부터 45까지의 숫자를 입력해야 합니다."}

        return nums.map{it.toInt()}
    }
    private fun inputBonusNum(winNum:List<Int>):Int{
        println("보너스 번호를 입력해 주세요.")
        var remainder = (1..45).toMutableList()
        for(i in winNum) {
            if (remainder.contains(i.toInt()))
                remainder.remove(i.toInt())
        }
        var ret :String = Console.readLine()
        require(ret.isNotEmpty()){"[ERROR] : 값을 입력해야 합니다."}
        require(ret.all{it.isDigit()}){"[ERROR] : 숫자만 입력해야 합니다."}
        require(remainder.contains(ret.toInt())){"[ERROR] : 올바른 숫자가 아닙니다."}
        return ret.toInt()
    }
    private fun getWinningHistory(table: List<List<Int>>, winNum: List<Int>, bonusNum:Int) : Array<Int>{
        var ranks = Array(8,{0})
        for (lst in table){
            if (lst.filter{it in winNum}.size >=3)
                ranks[lst.filter{it in winNum}.size] += 1
            if (lst.filter{it in winNum}.size == 5 && lst.contains(bonusNum)){
                ranks[5] -= 1
                ranks[7] += 1
            }
        }
        return ranks
    }
    private fun printWinningHistory(ranks:Array<Int>){
        println("3개 일치 (5,000원) - " + ranks[3] + "개")
        println("4개 일치 (50,000원) - " + ranks[4]+ "개")
        println("5개 일치 (1,500,000원) - " + ranks[5]+ "개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks[7]+ "개")
        println("6개 일치 (2,000,000,000원) - " + ranks[6]+ "개")
    }
    private fun getWinRatio(money:Int, ranks: Array<Int>):Double{
        var prizeSum : Double = 0.00
        for (i in 3..7) {
            if (i == 3)
                prizeSum += Rank.FIFTH.prize * ranks[i]
            if (i == 4)
                prizeSum += Rank.FOURTH.prize * ranks[i]
            if (i == 5)
                prizeSum += Rank.THIRD.prize * ranks[i]
            if (i == 6)
                prizeSum += Rank.FIRST.prize * ranks[i]
            if (i == 7)
                prizeSum += Rank.SECOND.prize * ranks[i]
        }
        return (prizeSum/money * 100)
    }
    private fun printWinRatio(winRatio:Double){
        println("총 수익률은 ${winRatio}%입니다.")
    }
    fun gameStart(){
        money = inputMoney()
        table = publishLotto(money)
        printLottos(table)
        var winNum :List<Int> = inputWinNum()
        bonusNum = inputBonusNum(winNum)
        printWinningHistory(getWinningHistory(table,winNum,bonusNum))
        printWinRatio(getWinRatio(money,getWinningHistory(table,winNum,bonusNum)))
    }
}