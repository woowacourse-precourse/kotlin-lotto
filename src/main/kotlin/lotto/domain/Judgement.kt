package lotto.domain

class Judgement {
    // 일치하는 번호의 개수를 반환한다.
    fun countMatchNumber(lottoNumber: List<Int>, winningNumber: List<Int>): Int {
        var matchCount = 0
        for (lucky in winningNumber) {
            if (lottoNumber.contains(lucky)) {
                matchCount++
            }
        }
        return matchCount
    }

    // 로또 번호에 보너스 번호가 포함되어 있는지 검사한다.
    fun checkBonusBall(lottoNumber: List<Int>, bonusNumber: Int): Boolean {
        return lottoNumber.contains(bonusNumber)
    }
}