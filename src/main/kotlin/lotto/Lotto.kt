package lotto

class Lotto(private val numbers: List<Int>) {   //입력받은 숫자가 형식에 맞는지 확인하는 코드
    init {
        require(numbers.size == 6)
        require(numbers.distinct() == numbers)
    }


    // TODO: 추가 기능 구현
}
