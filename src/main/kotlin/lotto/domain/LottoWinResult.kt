package lotto.domain

class LottoWinResult() {

    private val lottoResult = mutableMapOf<Ranking, Int>()

    fun getLottoResult(checkLotto: List<Ranking>): MutableMap<Ranking, Int> {
        for (i in Ranking.values()) {
            lottoResult[i] = 0
        }

        for (i in checkLotto) {
            lottoResult[i] = lottoResult[i]!! + 1
        }
        return lottoResult
    }
}