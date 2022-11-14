package lotto

class Lottos {
    val lottos: MutableList<Lotto> = mutableListOf<Lotto>()
    fun addLotto(lotto: Lotto) {
        lottos.add(lotto)
    }

    fun printLottos() {
        for (i in lottos.indices) {
            lottos[i].printLotto()
        }
    }

    fun matchLottos(winningNumbers: List<Int>, bonusNumber: Int): MutableMap<WinningType, Int> {
        val winningResult = mutableMapOf(WinningType.FIRST to 0,
                WinningType.SECOND to 0,
                WinningType.THIRD to 0,
                WinningType.FOURTH to 0,
                WinningType.FIFTH to 0,
                WinningType.NOTHING to 0)
        for(i in lottos.indices) {
            val type = lottos[i].matchLotto(winningNumbers, bonusNumber)
            winningResult[type] = winningResult[type]!! + 1
        }
        return winningResult
    }
}