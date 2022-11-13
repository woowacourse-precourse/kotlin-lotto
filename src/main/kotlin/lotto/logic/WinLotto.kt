package lotto.logic

class WinLotto {
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
}