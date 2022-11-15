package lotto.domain.lotto

class WinningNumber(private val winningNumber: String) {
    init {
        require(isValidInclusionComma()) { println(IS_INCLUSION_COMMA) }
    }

    private fun isValidInclusionComma(): Boolean =
        winningNumber.count { comma -> comma == ',' } == 5

    companion object {
        private const val IS_INCLUSION_COMMA = "[ERROR] 당첨 번호에 콤마가 포함되어 있는지 확인해주세요."
    }
}