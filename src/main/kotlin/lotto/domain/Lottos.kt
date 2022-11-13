package lotto.domain

class Lottos(private val lottos: List<Lotto>) {
    fun matchingLottoNum(winningLotto: WinningLotto): MutableList<Ranking> {
        val resultList = mutableListOf<Ranking>()
        for (lotto in lottos) {
            resultList.add(winningLotto.matching(lotto.getLottoNumberList()))
        }
        return resultList
    }

    fun getLottosList(): MutableList<Lotto> {
        val listLottos = mutableListOf<Lotto>()
        for (i in lottos) {
            listLottos.add(i)
        }
        return listLottos
    }
}