package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}

class LottoWinningStat (private val purchaseAmount: Int, private val lottoNumbers: List<Int>, private val bonusNumber: Int){
    private val lotto: Lotto = Lotto(lottoNumbers)


    private fun validateIsIncludedInLotto(number: Int, lotto: Lotto) {
        if(lotto.contains(number)){
            println("[ERROR] 보너스 번호가 당첨 번호와 중복됨")
            throw IllegalArgumentException()
        }
    }
}