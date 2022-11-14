package lotto

enum class Error (val string:String){
    DIVIDE("[ERROR] 1000으로 나누어 떨어지게 입력하세요"),
    ONLY_NUMBER("[ERROR] 숫자만 입력하세요"),
    SIX_NUMBER("[ERROR] 6개를 입력하세요"),
    OVERLAP("[ERROR] 중복된 수를 입력했습니다"),
    RANGE("[ERROR] 1부터 45사이의 번호를 입력하세요")
}