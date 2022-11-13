package lotto

//함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
//함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
//else를 지양한다.
//힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
//때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
//Enum 클래스를 적용해 프로그래밍을 구현한다.

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
}
