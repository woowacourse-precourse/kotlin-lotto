package lotto.domain.model

class LottoStore(private val numberGenerator: GenerateLottoNumber = LottoNumberGenerator()) {

    private fun makeRandomNum(): List<Int> = numberGenerator.generate()

    fun generateLotto(): Lotto = Lotto(makeRandomNum().map {
        LottoNumber.valueOf(it)
    })

    fun purchaseLotto(money: Money): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat((money.getMoney() / Lotto.LOTTO_PRIZE).toInt()) {
            purchaseLottos.add(generateLotto())
        }
        return purchaseLottos.toList()
    }


}