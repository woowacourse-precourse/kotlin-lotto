package exception

class LottoBonus(number: Int) {
    init {
        require(number in 1..45) {
            "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        }
    }
}