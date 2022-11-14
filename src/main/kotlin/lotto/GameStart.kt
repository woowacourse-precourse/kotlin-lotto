package lotto


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