package lotto

//함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
//함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
//else를 지양한다.
//힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
//때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
//Enum 클래스를 적용해 프로그래밍을 구현한다.

//제공된 Lotto 클래스를 활용해 구현해야 한다.
//Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
//numbers의 접근 제어자인 private을 변경할 수 없다.
//Lotto에 필드를 추가할 수 없다. // 변수 사용금지
//Lotto의 패키지 변경은 가능하다.

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(numbers.distinct().size==6){"[ERROR] : 숫자가 중복되어 있습니다."}
        require(numbers[5] <= 45){"[ERROR] : 숫자가 45를 초과했습니다."}
        require(numbers[0] >= 1){"[ERROR] : 숫자가 1보다 작습니다."}
    }
}
