package lotto

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val lottoNumbers = makeLotto()
    val lotto = Lotto(lottoNumbers)
    val bonusNumber = makeBonusNumber(lottoNumbers)
}

fun makeLotto(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

fun makeBonusNumber(lottoNumbers: List<Int>): Int {
    var bonusNumber: Int
    while(true) {
        bonusNumber = Randoms.pickNumberInRange(1, 45)
        if (!lottoNumbers.contains(bonusNumber))
            break
    }
    return bonusNumber
}