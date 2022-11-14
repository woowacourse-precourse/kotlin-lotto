## 🚀 기능 목록

### ⌨️ Service Logic : User
- **사용자입력** : `@datatype : String`
1. **로또 구입 금액을 입력 받는다.**
   - [x] 입력 안내문 : `구입금액을 입력해 주세요.`
   - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
     -  구입 금액은 1,000원 단위로 입력 받는다
     -  **예외처리** `IllegalArgumentException`
        - [x] `@datatype : Int` 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
        - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
    
2. **당첨번호를 입력받는다.**
   - [x] 입력 안내문 : `당첨 번호를 입력해 주세요.`
   - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
     -  번호는 쉼표(,)를 기준으로 구분한다.
     -  **예외처리** `IllegalArgumentException`
          - [x] 숫자 범위는 1~45까지이다.
          - [x] 중복 숫자 확인
          - [x] 입력된 숫자의 길이가 6인지 확인한다
          - [x] 구분자가 `,`가 아닌 경우
          - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
3. **보너스 번호를 입력받는다.**
   - [x] 입력 안내문 : `보너스 번호를 입력해 주세요.`
   - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
     -  **예외처리** `IllegalArgumentException`
          - [x] 숫자 범위는 1~45까지이다.
          - [x] 1자리 수 인지 확인한다
          - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.

### 🧮 Domain Logic : Lotto
- **Lotto 클래스 제약사항**
  - 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
  - `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
  - `numbers`의 접근 제어자인 private을 변경할 수 없다.
  - `Lotto`에 필드를 추가할 수 없다.
  - `Lotto`의 패키지 변경은 가능하다.

- **컴퓨터 6자리 수 로또 난수** : `@datatype : List<Int>`

1. **6자리수 생성.**
    - [x] 숫자 범위는 1~45까지이다.
    - [x] 난수생성 `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`
    - [x] 서로 다른 수
2. **구입 금액만큼 로또 발행한다.**
   - [x] @repeat **6자리수 생성**
3. **발행한 로또 수량 및 번호를 출력**
   - [x]  콘솔출력: `n 개를 구매했습니다.`
   - [x]  로또 번호는 오름차순으로정렬
4. **당첨 내역 계산**
   1. **일치하는 숫자 개수 계산**
      - [x] 발행된 로또와 당첨번호 `@datatype List<Int>` 의 index 0~5를 비교하여 일치하는 개수를 계산한다.
      - [x] 발행된 로또와 보너스번호 `@datatype Int`를 비교하여 일치하는지 확인한다.
   2. **당첨 등수와 수익률 계산** 
       - [x] 일치하는 숫자 개수와 보너스 번호 일치여부를 합산하여 당첨 등수와 수익률`@datatype : Float` `(당첨금/구입금액 * 100)`을 계산한다.
         - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
5. **당첨내역 출력**
   - [x] 콘솔 출력 : 1~5등까지 당첨 횟수
   - [x] 콘솔 출력: 당첨 금액 계산 `총 수익률은 62.5%입니다.`


---
## 📌 비기능 요구사항 목록
- **Commit Convention**
  - Git의 커밋([커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)) 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위로 추가.
  - Format of the commit message
    ```
    <type>(<scope>): <subject>
    <BLANK LINE>
    <body>
    <BLANK LINE>
    <footer>
    ```

- **Coding Convention**
  - [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수
  - [코틀린 스타일 가이드](https://developer.android.com/kotlin/style-guide?hl=ko)
  - [클린 코드 체크 리스트](https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md) 
  - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
  - Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
  - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
  - Enum 클래스를 적용해 프로그래밍을 구현한다.

- **Test**
  - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
  - 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/kotlin/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.
- **Allowed Libraries**
  - 아래의 허용된 라이브러리 외 외부 라이브러리를 사용하지 않는다.
  - `camp.nextstep.edu.missionutils.Console`
  - `camp.nextstep.edu.missionutils.Randoms`