package lotto

class Lotto(private val numbers: List<Int>) {

    // 생성자 초기화 블럭
    init {
        require(numbers.size == 6)
    }
}
