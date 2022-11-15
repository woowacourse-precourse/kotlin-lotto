package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){
            "[ERROR] 로또 번호는 6 개의 숫자 입니다."
        }
        require(numbers.distinct().size == 6){
            "[ERROR] 로또 번호는 중복되지 않습니다."
        }

    }

    // TODO: 추가 기능 구현
}
