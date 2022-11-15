package lotto

class LottoResult {
    fun checkEqualNumber(winningNumber: List<Int>, lottoNumber: List<Int>): List<Int> {
        val count = mutableListOf(0, 0)

        for (index in 0 until winningNumber.size - 1) {
            if (lottoNumber.contains(winningNumber[index]))
                count[0] += 1
        }

        if (count[0] == 5 && lottoNumber.contains(winningNumber.last()))
            count[1] += 1

        return count
    }
}