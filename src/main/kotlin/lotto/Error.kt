package lotto

enum class Error(val message: String) {
    NotDivideThousand("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    DuplicateNumber("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    SixNumber("[ERROR] 로또 번호는 6자리여야 합니다."),
    NotNumber("[ERROR] 숫자를 입력해야 합니다.")
}