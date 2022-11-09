package lotto

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.maxLottoNumber
import lotto.Constant.Companion.minLottoNumber

class Ticket {
    private fun randomNumber() = pickNumberInRange(minLottoNumber, maxLottoNumber) // 1 ~ 45 랜덤 숫자 생성

    private fun appendNumber(randomNumber: Int, numberList: MutableList<Int>) {
        if (!numberList.contains(randomNumber)) { // 중복된 숫자가 아니면 add
            numberList.add(randomNumber)
        }
    }

    private fun makeLotto(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()
        while (lottoNumbers.size < lottoSize) {
            appendNumber(randomNumber(), lottoNumbers)
        }
        return lottoNumbers
    }
}