package lotto

class Seller(
    private val machine: LottoGenerator,
) : LottoSeller {

    override fun sellLotto(receivedMoney: Int): List<Lotto> {
        val generatedLotto = ArrayList<Lotto>()

        repeat(receivedMoney / LOTTO_PRICE) {
            generatedLotto.add(machine.generateLotto())
        }
        return generatedLotto.toList()
    }
}