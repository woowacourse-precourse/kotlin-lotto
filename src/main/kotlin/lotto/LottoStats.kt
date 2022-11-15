package lotto

import lotto.LottoStats as LottoStats

enum class LottoStats(val message: String, val price: Int, var Cnt: Int) {
    FIFTH_RANK("3개 일치 (5,000원)", 5_000, 0),
    FORTH_RANK("4개 일치 (50,000원)", 50_000, 0),
    THIRD_RANK("5개 일치 (1,500,000원)", 1_500_000, 0),
    SECOND_RANK("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 0),
    FIRST_RANK("6개 일치 (2,000,000,000원)", 2_000_000_000, 0);

    companion object {
        fun lottoMatchLists(userLottoList: List<Int>, comLottoList: List<Int>) {
            var answerCnt = 0
            var bonusCnt = 0
            for (target in userLottoList) {
                if (comLottoList.subList(0, 6).contains(target)) {
                    answerCnt += 1
                } else if (comLottoList.subList(6, 7).contains(target)) {
                    bonusCnt += 1
                }
            }
            if (answerCnt == 6) {
                answerCnt += 1
            } else if (answerCnt == 5 && bonusCnt == 1) {
                answerCnt += 1
            }
            return findRank(answerCnt)
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


}