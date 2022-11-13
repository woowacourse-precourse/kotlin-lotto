package domain

import camp.nextstep.edu.missionutils.Randoms

class CreateLottoNumber {

    private val ERROR_MESSAGE_LOTTO_NUMBER = "[ERROR] 로또 번호 추첨 개수는 6개여야 합니다."

    // 랜덤으로 로또 숫자 6개 생성
    fun createRandomLottoNumber(): List<Int>{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        // 중복된 숫자가 나왔을 경우 예외처리
        if (numbers.toSet().size < 6)
            throw IllegalArgumentException("$ERROR_MESSAGE_LOTTO_NUMBER ")

        return numbers.sorted()
    }

}