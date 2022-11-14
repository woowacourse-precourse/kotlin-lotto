package lotto.domain

class WinLotto {

    fun getRankResult(lottos: ArrayList<List<Int>>, winningNum: List<Int>, bonusNum: Int): MutableMap<Rank, Int>{
        var rankResult = mutableMapOf<Rank, Int>()
        rankResult = initializeMap(rankResult)

        for(i in lottos.indices){
            var cntSame = countSameNum(lottos[i], winningNum)

            var isBonus = false
            if(isContainBonusNum(lottos[i], bonusNum))
                isBonus = true

            rankResult = addToRankResult(cntSame, rankResult, isBonus)
        }

        return rankResult
    }

    private fun initializeMap(rankResult: MutableMap<Rank, Int>): MutableMap<Rank, Int>{
        for(i in Rank.values()){
            rankResult[i] = 0
        }

        return rankResult
    }

    private fun countSameNum(lotto: List<Int>, winningNum: List<Int>):Int{
        var cntSame = 0
        for(i in winningNum.indices){
            if(lotto.contains(winningNum[i]))
                cntSame++
        }
        return cntSame
    }

    private fun isContainBonusNum(lotto: List<Int>, bonusNum: Int): Boolean{
        return lotto.contains(bonusNum)
    }

    private fun addToRankResult(cntSame: Int, rankResult: MutableMap<Rank, Int>, isBonus: Boolean): MutableMap<Rank, Int>{
        when(cntSame){
            3 -> rankResult[Rank.Fifth] = rankResult[Rank.Fifth]!! + 1
            4 -> rankResult[Rank.Fourth] = rankResult[Rank.Fourth]!! + 1
            5 -> {
                if(!isBonus)
                    rankResult[Rank.Third] = rankResult[Rank.Third]!! + 1
                else
                    rankResult[Rank.Second] = rankResult[Rank.Second]!! + 1
            }
            6 -> rankResult[Rank.First] = rankResult[Rank.First]!! + 1
        }

        return rankResult
    }
}