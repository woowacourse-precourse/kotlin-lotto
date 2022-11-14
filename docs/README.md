# 🚀 구현할 기능 목록

## 1. main

- [x] 금액 입력 및 로또 수량 계산 메서드 추가
- [x] 입력 받은 금액 예외처리 메서드 추가
- [x] 당첨 번호 입력 메서드 추가
- [ ] 당첨 번호 예외처리 메서드 추가
- [x] 보너스 번호 입력 메서드 추가
- [ ] 보너스 번호 예외처리 메서드 추가
- [ ] 발행한 로또 수량 및 번호 출력 메서드 추가
- [ ] 당첨 내역 출력 메서드 추가
- [ ] 수익률 게산 및 출력 메서드 추가


## 2. Lotto 클래스

- [ ] 로또 번호 생성 및 출력 메서드 추가
- [ ] 당첨 여부 체크 메서드 추가
- [ ] 보너스 번호 포함 당첨 여부 체크 메서드 추가

# 🚨 프로그래밍 요구 사항

### * 프로그램 실행의 시작점은 Application의 main()이다.

### * [Kotlin 코드 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)

### * 프로그램 종료 시 `System.exit()`를 호출하지 않는다.

### * indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

### * 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### * JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### * 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### * else를 지양한다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.

### * Enum 클래스를 적용해 프로그래밍을 구현한다.

### * 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- 단위 테스트 작성이 익숙하지 않다면 test/kotlin/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

### *  `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

### * Lotto 클래스
- 제공된 Lotto 클래스를 활용해 구현해야 한다.
- Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.
