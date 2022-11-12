package lotto

object ResultExtractor {
    fun extractResult(
        generatedLotto: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): MutableMap<LottoStatus, Int> {
        val result = mutableMapOf<LottoStatus, Int>()

        generatedLotto.forEach { eachLotto ->
            val lottoStatus = eachLotto.checkLotto(winningNumbers, bonusNumber)

            result[lottoStatus] = if (!result.contains(lottoStatus)) {
                1
            } else {
                result[lottoStatus]!! + 1
            }
        }
        return result
    }
}