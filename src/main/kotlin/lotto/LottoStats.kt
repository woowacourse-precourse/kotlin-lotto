package lotto

import lotto.LottoStats as LottoStats

enum class LottoStats(val message: String, val price: Int, private var Cnt: Int) {
    FIRST_RANK("6개 일치", 2_000_000_000, 0),
    SECOND_RANK("5개 일치, 보너스볼 일치", 30_000_000, 0),
    THIRD_RANK("5개 일치", 1_500_000, 0),
    FORTH_RANK("4개 일치", 50_000, 0),
    FIFTH_RANK("3개 일치", 5_000, 0);
    fun lottoMatchLists(userLottoList : List<Int>, comLottoList : List<Int>) {
        var answerCnt = 0
        var bonusCnt = 0
        var cnt = 0
        for (target in userLottoList){
            if(comLottoList.subList(0,6).contains(target)){
                answerCnt += 1
            } else if(comLottoList.subList(6,7).contains(target)) {
                bonusCnt += 1
            }
        }
        if(answerCnt == 6){
            answerCnt += 1
        } else if (answerCnt == 5 && bonusCnt == 1){
            cnt = 6
        }
        cnt = answerCnt
        return findRank(cnt)
    }

    private fun findRank(cnt : Int){
        when(cnt){
            7 -> FIRST_RANK.Cnt += 1
            6 -> SECOND_RANK.Cnt += 1
            5 -> THIRD_RANK.Cnt += 1
            4 -> FORTH_RANK.Cnt += 1
            3 -> FIFTH_RANK.Cnt += 1
            }
    }
}