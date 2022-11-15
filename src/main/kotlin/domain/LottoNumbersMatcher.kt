package domain

class LottoNumbersMatcher(private val numbers: List<Int>,
                        private val bonusNumber: Int,
                        private val randomLottoes: List<List<Int>>) {
    /**
     * 전체 로또를 비교하여 계산해주는 함수
     */
    fun calculateTotalMatchCount(){
        for (index in randomLottoes.indices){
            calculateMatchCount(randomLottoes[index])
        }
    }

    /**
     * 구입한 로또 하나와 입력한 로또 번호들을 비교하는 함수
     */
    fun calculateMatchCount(randomLotto: List<Int>){
        var matchCount = 0.0
        for (index in numbers.indices){
            if (randomLotto.contains(numbers[index]))
                matchCount += 1
        }
        if (matchCount == 5.0 && randomLotto.contains(bonusNumber))
            matchCount += 0.5
        saveMatchCount(matchCount)
    }

    /**
     *  로또 번호가 일치한 개수에 따라 MatchStorage 에 저장하는 함수
     */
    fun saveMatchCount(matchCount: Double){
        when (matchCount) {
            3.0 -> MatchStorage.MATCH_THREE.matchCount += 1
            4.0 -> MatchStorage.MATCH_FOUR.matchCount += 1
            5.0 -> MatchStorage.MATCH_FIVE.matchCount += 1
            5.5 -> MatchStorage.MATCH_FIVE_WITH_BONUS_NUMBER.matchCount += 1
            6.0 -> MatchStorage.MATCH_SIX.matchCount += 1
        }
    }
}


