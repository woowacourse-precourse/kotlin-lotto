package lotto

class Lotto(private val numbers: List<Int>) {

    enum class functions {
        checkResult()
    }
    init {
        require(numbers.size == 6)
    }

    fun checkResult(lottoNums: Array<Int>) {
        val different = lottoWinNum.toSet().minus(lottoNums.toSet()) // 당첨 번호와 선정된 번호 중 겹치지 않는 숫자 구하기
    }
}
