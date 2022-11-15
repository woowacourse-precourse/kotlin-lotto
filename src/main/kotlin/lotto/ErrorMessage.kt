package lotto

enum class ErrorMessage(val message:String) {
    WRONGINPUT("[ERROR]잘못된 입력입니다."),
    OUTOFRANGE("[ERROR]범위를 벗어난 숫자입니다."),
    OVERLAPPING("[ERROR]중복된 숫자가 있습니다."),
}