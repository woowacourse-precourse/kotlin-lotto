package lotto.domain

class CONSTANT() {
    enum class STAGE(val message: String){
        PRICEINPUT("구입금액을 입력해 주세요."),
        LOTTOCOUNTOUPUT("개를 구매했습니다.")
    }
    enum class ERRORMESSAGE(val message:String) {
        CHECKPRICEINTERROR("[ERROR] 로또 구입 금액이 정수가 아닙니다."),
        CHECKPRICEUNDERZEROERROR("[ERROR] 로또 구입 금액이 0 이하입니다."),
        CHECKPRICETHOUSANDSUNITERROR("[ERROR] 로또 구입 금액이 1,000원 단위가 아닙니다."),
        CHECKLOTTONUMBERCONUTERROR("[ERROR] 로또 번호 개수는 6개입니다."),
        CHECKLOTTONUMBERDUPLICATED("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
        CHECKLOTTONUMBERRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    enum class PRICE(val params:Int){
        MIN_PRICE(0),
        UNIT(1000)
    }
    enum class LOTTO(val params:Int){
        MIN_LOTTO_NUMBER(1),
        MAX_LOTTO_NUMBER(45),
        LOTTO_COUNT(6)
    }
}