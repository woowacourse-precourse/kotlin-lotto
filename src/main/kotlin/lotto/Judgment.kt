package lotto

class Judgment {
    fun checkPurchaseAmount(input: String){
        // input값을 Int 타입으로 변환했을 때 null이면 예외처리
        // 1000으로 나누어 떨어지지 않으면 예외처리
        if (input.toIntOrNull() == null){
            throw IllegalArgumentException("[ERROR] 구매 금액을 숫자 형태로 입력해야 합니다.")
        }
        else if (input.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구매 금액을 1000원 단위로 입력하세요.")
        }
    }

}