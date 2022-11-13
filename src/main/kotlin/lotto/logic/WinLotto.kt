package lotto.logic

class WinLotto {
    private fun initializeMap(rankResult: MutableMap<Rank, Int>): MutableMap<Rank, Int>{
        for(i in Rank.values()){
            rankResult[i] = 0
        }

        return rankResult
    }
}