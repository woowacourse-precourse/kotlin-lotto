package lotto

class LottoProvider {

    fun provideLottos(cost: Int): List<Lotto> {

        val lottos = mutableListOf<Lotto>()
        repeat(cost / LOTTO_COST) {
            lottos.add(Lotto.generate())
        }
        return lottos
    }
}