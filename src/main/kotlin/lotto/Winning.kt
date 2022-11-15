package lotto

class Winning {
    fun getCountOfMatchWinning(lottoNumbers: List<Int>, winningNum: List<Int>): Int{
        var matchCount = 0
        for(i in 0..5){
            if(lottoNumbers.contains(winningNum[i])){
                matchCount += 1
            }
        }
        return matchCount
    }
}