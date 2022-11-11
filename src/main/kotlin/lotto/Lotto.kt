package lotto

class Lotto(private val numbers: List<Int>) {
    //    제공된 Lotto 클래스를 활용해 구현해야 한다.
//    Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
//    numbers의 접근 제어자인 private을 변경할 수 없다.
//    Lotto에 필드를 추가할 수 없다.
//    Lotto의 패키지 변경은 가능하다.
    init {
        require(numbers.size == 6)
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}
