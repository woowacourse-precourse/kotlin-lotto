package lotto

/*
1. 제공된 Lotto 클래스를 활용해 구현해야 한다.
2. Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
3. numbers의 접근 제어자인 private을 변경할 수 없다.
4. Lotto에 필드를 추가할 수 없다. == 주어진거 외 변수를 쓰지마라
5. Lotto의 패키지 변경은 가능하다.
*/

/*
클래스 구현 순서
class A {
    프로퍼티

    init 블록

    부 생성자

    메서드

    동반 객체
}
*/

// private 최상위에서 이용할때 : 파일 내부에서만 이용
// private 클래스 멤버에서 이용할때 : 클래스 내부에서만 이용
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

}