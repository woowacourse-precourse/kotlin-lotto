package lotto.domain.lotto

class BonusNumber(private val lottoNumbers: List<Int>, private val bonusNumber: Int) {

    init {
        require(isValiInclusionBonusNumber()) { println(INCLUSION_BONUSNUMBER) }
    }

    private fun isValiInclusionBonusNumber(): Boolean =
        !lottoNumbers.contains(bonusNumber)

    companion object {
        private const val INCLUSION_BONUSNUMBER = "[ERROR] 보너스 번호는 당첨 번호에 포함되면 안됩니다."
    }
}