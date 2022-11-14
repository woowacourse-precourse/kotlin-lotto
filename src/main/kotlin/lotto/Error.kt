package lotto

enum class Error(val message: String) {
    NotDivideThousand("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    NotNumber("[ERROR] 숫자를 입력해야 합니다.")
}