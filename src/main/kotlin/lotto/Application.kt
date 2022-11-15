package lotto

import lotto.domain.*

fun main() {
    val price = stage1()
    if (price == -1) return
    val lottos = stage2(price)
    if (lottos == -1) return
    val winning = stage3()
    if (winning == -1) return
    val bonus = stage4(winning as Lotto)
    if (bonus == -1) return
    val rankingResult = stage5(lottos as List<Lotto>, winning,bonus)
    stage6(rankingResult,price)
}
