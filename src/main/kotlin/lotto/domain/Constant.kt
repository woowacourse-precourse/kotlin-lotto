package lotto.domain

class Constant() {
    enum class ErrorMessage(val message:String) {
        CheckPriceIntError("[ERROR] 로또 구입 금액이 정수가 아닙니다."),
        CheckPriceUnderZeroError("[ERROR] 로또 구입 금액이 0 이하입니다."),
        CheckPriceThousandsUnitError("[ERROR] 로또 구입 금액이 1,000원 단위가 아닙니다."),
        CheckLottoNumberCountError("[ERROR] 로또 번호 개수는 6개입니다."),
        CheckLottoNumberDuplicated("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
        CheckLottoNumberRange("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    enum class Price(val params:Int){
        MIN_PRICE(0),
        UNIT(1000)
    }
    enum class Lotto(val params:Int){
        MIN_LOTTO_NUMBER(1),
        MAX_LOTTO_NUMBER(45),
        LOTTO_COUNT(6)
    }
}