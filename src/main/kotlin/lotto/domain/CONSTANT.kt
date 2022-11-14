package lotto.domain

class CONSTANT() {
    enum class STAGE(val message: String){
        PRICEINPUT("구입금액을 입력해 주세요."),
        LOTTOCOUNTOUPUT("개를 구매했습니다."),
        WINNINGINPUT("당첨 번호를 입력해 주세요."),
        BONUSINPUT("보너스 번호를 입력해 주세요."),
        STATISTICSOUPUT("당첨 통계\n ---")
    }
    enum class ERRORMESSAGE(val message:String) {
        PRICEINTERROR("[ERROR] 로또 구입 금액이 정수가 아닙니다."),
        PRICEUNDERZEROERROR("[ERROR] 로또 구입 금액이 0 이하입니다."),
        PRICETHOUSANDSUNITERROR("[ERROR] 로또 구입 금액이 1,000원 단위가 아닙니다."),
        LOTTONUMBERCONUTERROR("[ERROR] 로또 번호 개수는 6개입니다."),
        LOTTONUMBERDUPLICATEDERROR("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
        LOTTONUMBERRANGEERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        LOTTONUMBERINTERROR("[ERROR] 로또 번호는 숫자여야 합니다."),
        BONUSNUMBERINTERROR("[ERROR] 보너스 번호는 숫자여야 합니다."),
        BONUSNUMBERRANGEERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        BONUSNUMBERDUPLICATEDERROR("[ERROR] 보너스 번호가 이미 당첨 번호에 포함돼 있습니다.")
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
    enum class RANKING(val params:Int){
        FIRST(6),
        SECOND(5),
        THIRD(5),
        FOURTH(4),
        FIFTH(3),
        NONE(0)
    }
    enum class RANKINGMESSAGE(val message:String){
        FIRST("6개 일치 (2,000,000,000원) - "),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        THIRD("5개 일치 (1,500,000원) - "),
        FOURTH("4개 일치 (50,000원) - "),
        FIFTH("3개 일치 (5,000원) - "),
        UNIT("개")
    }
}