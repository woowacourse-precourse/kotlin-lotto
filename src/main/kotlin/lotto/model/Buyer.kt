package lotto.model

import kotlin.properties.Delegates

object Buyer {
    var amount by Delegates.notNull<Int>()

    val lottos = mutableListOf<Lotto>()

    fun getBuyCount(): Int {
        return amount / 1000
    }
/*    companion object {
        var payMoney = ""
        var buyCount = 0
    }*/
}