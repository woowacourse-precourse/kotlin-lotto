package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    
    fun getLottoNumbers(): List<Int> = numbers
    // TODO: 추가 기능 구현
}
