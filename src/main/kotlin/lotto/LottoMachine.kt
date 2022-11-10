package lotto

class LottoMachine(private val money: Int) {
    fun sellLottos(): Int =
        money / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}