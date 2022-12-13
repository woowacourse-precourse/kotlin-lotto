package lotto.model

class Buyer {
    var lottoCount: Int = 0
        set(money: Int) {
            field = money / 1000
        }
/*    companion object {
        var payMoney = ""
        var buyCount = 0
    }*/
}