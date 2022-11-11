package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(lottoAmount: String) {
    private var lottoCount = 0
    private val lottery = mutableListOf<Lotto>()
    private val rank = mutableListOf(0,0,0,0,0,0,0,0)

    init {
        validateTypeAmount(lottoAmount)
        validateUnitAmount(lottoAmount)
        lottoCount = lottoAmount.toInt() / LOTTO_PRICE
    }

    fun getLottoNumbers() {
        for (index in 0 until lottoCount) {
            lottery[index].printLottoNumber()
        }
    }

    fun getLottoCount() = lottoCount

    fun pickNewLotto(count: Int) {
        for (index in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottery.add(Lotto(numbers))
        }
    }

    fun validateTypeAmount(amount: String){
        val typeCount = amount.filter { number ->
            number in '0'..'9'
        }
        require(typeCount.length == amount.length) {
            throw IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력해주세요.")
        }
    }

    fun validateUnitAmount(amount: String): Boolean {
        return when (amount.toInt() % LOTTO_PRICE) {
            0 -> true
            else -> throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요")
        }
    }

    fun getTotalRank(luckyNumber: List<Int>, bonusNumber: Int) : List<Int>{
        for(index in 0 until lottoCount){
            val increaseRank = lottery[index].confirmWinning(luckyNumber, bonusNumber)
            rank[increaseRank]++
        }

        return rank
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}