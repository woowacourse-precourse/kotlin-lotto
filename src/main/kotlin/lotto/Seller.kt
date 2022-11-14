package lotto

class Seller(
    private val machine: LottoGenerator,
) : LottoSeller {

    override fun sellLotto(receivedMoney: Int): List<Lotto> {
        val generatedLotto = ArrayList<Lotto>()
        val lottoCount = receivedMoney / LOTTO_PRICE

        repeat(lottoCount) {
            generatedLotto.add(machine.generateLotto())
        }
        return generatedLotto.toList()
    }
}