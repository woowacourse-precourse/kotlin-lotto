package lotto

enum class Error(val message: String) {
    NotDivideThousand("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    DuplicateNumber("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다."),
    SixNumber("[ERROR] 로또 번호는 6자리여야 합니다."),
    BonusNumber("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    NotNumber("[ERROR] 숫자를 입력해야 합니다.")
}