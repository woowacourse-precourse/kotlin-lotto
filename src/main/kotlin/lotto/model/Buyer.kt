package lotto.model

object Buyer {
    var lottoCount: Int = 0
        set(money) {
            field = money / 1000
        }

    val lottos = mutableListOf<Lotto>()
/*    companion object {
        var payMoney = ""
        var buyCount = 0
    }*/
}