package lotto.domain

class BonusNumberError(lottoNumber: List<Int>, bonusNumber: Int) {

    init {
        require(!lottoNumber.contains(bonusNumber)) { "[ERROR] 로또 당첨 번호와 같은 수가 포함되어 있습니다." }
        require(bonusNumber.toInt() in 1..45) { "[ERROR] 1 ~ 45까지의 숫자를 입력하세요." }
    }

}