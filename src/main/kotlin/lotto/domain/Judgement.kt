package lotto.domain

class Judgement {
    // 일치하는 번호의 개수를 반환한다.
    fun countMatchNumber(lottoNumber: List<Int>, winningNumber: List<Int>): Int {
        var result = 0
        for (lucky in winningNumber) {
            if (lottoNumber.contains(lucky)) {
                result++
            }
        }
        return result
    }
}