package lotto

class Seller(
    private val machine: LottoGenerator,
) : LottoSeller {

    override fun sellLotto(receivedMoney: Int, lottoPrice:Int): List<Lotto> {
        val generatedLotto = ArrayList<Lotto>()

        repeat(receivedMoney / lottoPrice) {
            generatedLotto.add(machine.generateLotto())
        }
        return generatedLotto.toList()
    }
}