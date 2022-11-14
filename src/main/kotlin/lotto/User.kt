package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    fun userInput() : Lotto{
        println("\n당첨 번호를 입력해 주세요.")
        var user = Console.readLine()
        var token = user.split(",")
        val userInputNum = mutableListOf<Int>()

        for(i in token){
            LottoError.checkIsNum(i)
            userInputNum.add(i.toInt())
        }
        return Lotto(userInputNum.toList())
    }

    fun userBonusInput(userNum: List<Int>): Int{
        println("\n보너스 번호를 입력해 주세요.")

        var bonusNum = Console.readLine()

        LottoError.checkBonusNum(bonusNum, userNum as MutableList<Int>)

        return bonusNum.toInt()
    }

    fun makeStatistics(money : Int, lottery : MutableList<MutableList<Int>>, userNum : List<Int>, bonusNum : Int){
        println("\n당첨 통계")
        println("---")

        var winLottery : HashMap<Int, Int> = mutableMapOf(
                LotteryResult.THREE.correct to 0,
                LotteryResult.FOUR.correct to 0,
                LotteryResult.FIVE.correct to 0,
                LotteryResult.FIVEANDBONUS.correct to 0,
                LotteryResult.SIX.correct to 0
        ) as HashMap<Int, Int>

        for (i in 0 until lottery.size) {
            var cnt = 0
            for (j in 0 until 6) {
                if (lottery[i].contains(userNum[j])) {
                    cnt++
                }
            }
            if (cnt == 5 && lottery[i].contains(bonusNum)) {
                cnt = LotteryResult.FIVEANDBONUS.correct
            }
            winLottery[cnt] = winLottery.getOrDefault(cnt, 0) + 1
        }

        var sum : Long = 0
        for (i in winLottery.keys) {
            if (i == LotteryResult.FIVEANDBONUS.correct) {
                println("5개 일치" + LotteryResult.printCost(i) + " - " + "${winLottery[i]}개")
                if(winLottery[i] != 0){
                    sum += LotteryResult.getCost(i)
                }
            } else if(i > 2){
                println("$i" + "개 일치" + LotteryResult.printCost(i) + " - " + "${winLottery[i]}개")
                if(winLottery[i] != 0){
                    sum += LotteryResult.getCost(i)* winLottery[i]!!
                }
            }
        }

        var  earningsRate = (sum/money.toDouble())*100

        val result = String.format("%.1f", earningsRate)
        println("총 수익률은 $result%입니다.")
    }
}