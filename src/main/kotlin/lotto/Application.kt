package lotto

fun main() {
    TODO("프로그램 구현")
}

enum class ErrorCode(val message : String){
    NUMERIC_REQUIRED("숫자만 입력해주세요"),
    COMMA_REQUIRED("쉼표로 숫자를 구분해주세요"),
    PRICE_UNQUALIFIED("1000원 단위로 입력해주세요")
}