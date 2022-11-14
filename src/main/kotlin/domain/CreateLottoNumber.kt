package domain

import camp.nextstep.edu.missionutils.Randoms

class CreateLottoNumber {

    private val ERROR_MESSAGE_LOTTO_NUMBER = "[ERROR] 로또 번호 추첨 개수는 6개여야 합니다."
    private val LOTTO_MIN_NUMBER = 1
    private val LOTTO_MAX_NUMBER = 45
    private val LOTTO_NUMBER = 6

    // 랜덤으로 로또 숫자 6개 생성
    fun createRandomLottoNumber(): List<Int>{
        val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER)
        // 중복된 숫자가 나왔을 경우 예외처리
        if (numbers.toSet().size < 6)
            throw IllegalArgumentException("$ERROR_MESSAGE_LOTTO_NUMBER ")

        return numbers.sorted()
    }

}