package lotto.domain

class Constant() {
    enum class ErrorMessage(val message:String) {
        CheckPriceIntError("[ERROR] 로또 구입 금액이 정수가 아닙니다."),
        CheckPriceUnderZeroError("[ERROR] 로또 구입 금액이 0 이하입니다."),
        CheckPriceThousandsUnitError("[ERROR] 로또 구입 금액이 1,000원 단위가 아닙니다.")
    }
    enum class Price(val params:Int){
        MIN_PRICE(0),
        UNIT(1000)
    }
}