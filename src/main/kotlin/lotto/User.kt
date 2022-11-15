package lotto

import camp.nextstep.edu.missionutils.Console

class User {

    // 당첨번호 입력
    fun userInput(): Lotto {
        println(Lotto.INPUTWINMONEY)
        var user = Console.readLine()
        var token = user.split(",")
        val userInputNum = mutableListOf<Int>()

        for (i in token) {
            LottoError.checkIsNum(i)
            userInputNum.add(i.toInt())
        }
        return Lotto(userInputNum.toList())
    }

    // 보너스 번호 입력
    fun userBonusInput(userNum: List<Int>): Int {
        println(Lotto.INPUTBONUSNUM)

        var bonusNum = Console.readLine()

        LottoError.checkBonusNum(bonusNum, userNum as MutableList<Int>)

        return bonusNum.toInt()
    }

    // 통계
    fun makeStatistics(money: Int, lottery: MutableList<MutableList<Int>>, userNum: List<Int>, bonusNum: Int) {
        var winLottery: HashMap<Int, Int> = lottoDictionary(lottery, userNum, bonusNum)
        var sum: Long = 0
        for (i in winLottery.keys) {
            if (i == LotteryResult.FIVEANDBONUS.correct) {
                println("5개 일치" + LotteryResult.printCost(i) + " - " + "${winLottery[i]}개")
                sum = calculateSum(winLottery, i, sum)
            } else if (i > 2) {
                println("$i" + "개 일치" + LotteryResult.printCost(i) + " - " + "${winLottery[i]}개")
                sum = calculateSum(winLottery, i, sum)
            }
        }

        var earningsRate = (sum / money.toDouble()) * 100
        val result = String.format("%.1f", earningsRate)
        println("총 수익률은 $result%입니다.")
    }

    // 당첨번호와 보너스 번호를 바탕으로 해시맵에 추가
    private fun lottoDictionary(lottery: MutableList<MutableList<Int>>, userNum: List<Int>, bonusNum: Int): HashMap<Int, Int> {
        Lotto.SHOWSTATISTICS
        var winLottery: HashMap<Int, Int> = mutableMapOf(
                LotteryResult.THREE.correct to 0,
                LotteryResult.FOUR.correct to 0,
                LotteryResult.FIVE.correct to 0,
                LotteryResult.FIVEANDBONUS.correct to 0,
                LotteryResult.SIX.correct to 0
        ) as HashMap<Int, Int>

        for (i in 0 until lottery.size) {
            var cnt = counting(lottery, i, userNum)
            if (cnt == 5 && lottery[i].contains(bonusNum)) {
                cnt = LotteryResult.FIVEANDBONUS.correct
            }
            winLottery[cnt] = winLottery.getOrDefault(cnt, 0) + 1
        }
        return winLottery
    }

    // 맞춘 개수 별 금액 계산
    private fun calculateSum(winLottery: HashMap<Int, Int>, i: Int, sum: Long): Long {
        var tmpSum = sum
        if (winLottery[i] != 0) {
            tmpSum += LotteryResult.getCost(i) * winLottery[i]!!
        }
        return tmpSum
    }

    // 맞춘 개수 카운팅
    private fun counting(lottery: MutableList<MutableList<Int>>, i: Int, userNum: List<Int>): Int {
        var cnt = 0
        for (j in 0 until 6) {
            if (lottery[i].contains(userNum[j])) {
                cnt++
            }
        }
        return cnt
    }
}