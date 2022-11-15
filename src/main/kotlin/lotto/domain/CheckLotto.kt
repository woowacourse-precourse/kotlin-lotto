package lotto.domain

class CheckLotto(
    private val lottoBundle: MutableList<List<Int>>,
    private val winningNumber: MutableList<Int>
) {

    var matchingCount = 0

    fun compareLotto(): MutableList<Int> {
        val lottoResult = mutableListOf<Int>()

        for (i in 0 until lottoBundle.size) {
            lottoResult.add(searchLottoNumber(lottoBundle[i]))
        }
        return lottoResult
    }

    private fun searchLottoNumber(myLotto: List<Int>): Int {
        matchingCount = 0

        if (myLotto.contains(winningNumber[6])) checkBonus.add(true) else checkBonus.add(false)

        for (lottoNumber in 0 until winningNumber.size) {
            compareLottoNumber(myLotto, lottoNumber)
        }
        return matchingCount
    }

    private fun compareLottoNumber(myLotto: List<Int>, lottoNumber: Int) {
        if (myLotto.contains(winningNumber[lottoNumber])) increaseMatchingCount()
    }

    private fun increaseMatchingCount() = matchingCount++

    companion object {
        var checkBonus = mutableListOf<Boolean>()
    }
}