package lotto

class LottoMachine(private val money: Int) {
    fun sellLottos(): Int =
        money / LOTTO_PRICE

    fun createLottos(): List<List<Int>> =
        List(sellLottos()) {
            createLotto()
        }

    private fun createLotto(): List<Int> {
        val lotto = LottoGenerator().generate()
        lotto.map { number ->
            LottoNumber(number)
        }
        Lotto(lotto)
        return lotto
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}