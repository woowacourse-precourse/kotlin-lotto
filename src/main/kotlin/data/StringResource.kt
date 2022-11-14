package data

enum class StringResource(val resource: String) {
    PURCHASE("구입 금액을 입력해주세요."),
    LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    NUMBERERROR("[ERROR] 숫자가 아닙니다."),
    REMAINDER("[ERROR] ${Price.STANDARD.price}원 단위로 입력하세요."),
    DUPLICATE("[ERROR] 중복된 숫자를 입력할 수 없습니다."),
    RANGEERROR("[ERROR] ${NumberRange.START.number}와 ${NumberRange.END.number} 사이의 숫자여야 합니다."),
    LENGTHERROR("[ERROR] 로또 번호는 ${NumberRange.MAX.number}개가 필요합니다."),
    TICKETS("_개를 구매했습니다."),
    UNDERBAR("_"),
    RATIO("총 수익률은 _%입니다.")

}
