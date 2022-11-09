package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){
            throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야합니다.")
        }
    }

    // TODO: 추가 기능 구현
}
