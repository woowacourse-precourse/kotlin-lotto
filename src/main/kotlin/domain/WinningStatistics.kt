package domain

import view.OutputView

class WinningStatistics {

    // 발행한 로또 번호와 당첨번호가 맞는지 확인(로또 리스트, 당첨 번호, 보너스 번호)
    fun winningStatistics(listOfLotto: Set<List<Int>>,correctLotto:List<Int>, bonus:Int): List<Pair<Int,Boolean>>{
        val winningRes = mutableListOf<Pair<Int,Boolean>>()
        for (lottoNumber in listOfLotto) {
            val lotto = Lotto(lottoNumber)
            winningRes.add(lotto.checkLotto(correctLotto, bonus))
        }

        return winningRes
        // 로또 일치 통계
        //OutputView().outputWinningStatisticsResult(winningMap(winningRes))

        // 총 수입
        //return incomeCalculation(winningRes)
    }

    // 로또 일치 통계
    fun winningMap(arr:List<Pair<Int,Boolean>>): Map<String, Int>{
        val lottoMap = mutableMapOf( Ranking.RANK3.rank to 0, Ranking.RANK4.rank to 0, Ranking.RANK5.rank to 0, Ranking.RANKBonus5.rank to 0, Ranking.RANK6.rank to 0)
        for (j in arr){
            if (j.first == 3)  lottoMap[Ranking.RANK3.rank] = lottoMap[Ranking.RANK3.rank]!! + 1
            if (j.first == 4) lottoMap[Ranking.RANK4.rank] = lottoMap[Ranking.RANK4.rank]!! + 1
            if (j.first == 5 && !j.second) lottoMap[Ranking.RANK5.rank] = lottoMap[Ranking.RANK5.rank]!! + 1
            if (j.first == 5 && j.second) lottoMap[Ranking.RANKBonus5.rank] = lottoMap[Ranking.RANKBonus5.rank]!! +1
            if (j.first == 6) lottoMap[Ranking.RANK6.rank] = lottoMap[Ranking.RANK6.rank]!! +1
        }
        //println(lottoMap)
        return lottoMap
    }

    // 총 수익
    fun incomeCalculation(arr:List<Pair<Int,Boolean>>):Int{
        var yield = 0
        for (j in arr){
            if (j.first == 3)  `yield` += Ranking.RANK3.price
            if (j.first == 4)  `yield` += Ranking.RANK4.price
            if (j.first == 5 && !j.second)  `yield` += Ranking.RANK5.price
            if (j.first == 5 && j.second)  `yield` += Ranking.RANKBonus5.price
            if (j.first == 6)  `yield` += Ranking.RANK6.price
        }
        return `yield`
    }


}