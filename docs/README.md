## 📮 기능 목록

1. 구입금액을 입력해주세요. 출력 - `showInputPurchasingAmount()`

2. 구입금액 입력 - `getPurchasingAmount()`
   - 예외처리 - `checkInputPurchasingAmount()`
     1. 1,000원 단위로 나누어 떨어지지 않을 때 - `hasRemainderOfPurchasingAmount()`
     2. 숫자가 아닐 때 - `isNumberOfPurchasingAmount()`

3. 입력한 금액 만큼 로또 번호 생성 후 오름차순 정렬 - `getLottoNumbers()`

4. 구매 갯수 및 로또 번호 출력 - `getLottoNumbers()`

5. 당첨 번호를 입력해 주세요. 출력 - `showInputWinningNumber()`

6. 당첨번호 입력 - `getWinningNumbers()`
   - 예외처리 - `checkInputWinningNumbers()`
     1. split 했을 때 숫자가 아닐 때 - `isNumberOfWinningNumbers()`
     2. split 했을 때 요소 수가 6개가 아닐 때 - `hasElementOfWinningNumbers()`
     3. 로또 범위 내 숫자가 아닐 때 - `isCorrectRangeOfWinningNumbers()`
     4. 중복이 있을 때 - `isUniqueOfWinningNumbers()`

7. 보너스 번호를 입력해 주세요. 출력 - `showInputBonusNumber()`

8. 보너스 번호 입력 - `getBonusNumber()`
   - 예외처리 - `checkInputBonusNumber()`
     1. 숫자가 아닐 때 - `isNumberOfBonusNumber()`
     2. 로또 범위 내 숫자가 아닐 때 - `isCorrectRangeOfBonusNumber()`
     3. 당첨 번호와 중복일 때 - `isUniqueOfBonusNumber()`

9. 구입한 로또 번호와 당첨 번호 비교 - `compareNumbers()`

10. 보너스 정보가 필요없는 등수 false로 고정 - `isBonusNecessary()`

11. 구입한 각 로또 번호의 등수 매칭 - `getRank()`

12. 구입한 전체 번호의 당첨 정보 전달 - `isWinningLotto()`

13. 당첨 통계 중 순위 당 갯수 계산 - `countRank()`

14. 당첨 통계 중 수익률 계산 - `calculateIncome()`

13. 다음과 같은 양식으로 당첨 통계 출력 - `showResultOfLotto()`
```kotlin
/**
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
*/
```
## 🔍 도메인 로직 & 어플리케이션 로직 분리

- 도메인 로직: 입력 받고 생성한 모든 값들을 이용해 로또 당첨을 계산하는 로직
- 어플리케이션 로직: 값을 입력 받고, 계산된 값을 출력하는 모든 로직


## 🎯 체크리스트

### 프로그래밍 요구 사항

- [x] Kotlin 코드 컨벤션 가이드 준수
- [x] indent depth 2까지 허용
- [x] 함수의 길이가 15라인을 넘어가지 않도록 설계
- [x] else를 지양
- [x] Enum 클래스를 적용해 구현
- [x] 도메인 로직에 단위 테스트를 구현. 단, UI 로직 제외
- [x] 핵심 로직과 UI 로직 분리 구현
- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API 사용하여 구현
- [x] 제공된 Lotto 클래스를 활용해 구현

### 2주차 공통 피드백

- [x] README.md 상세히 작성
- [x] 기능 목록 재검토
- [x] 기능 목록 업데이트
- [x] 값 하드 코딩 X
- [x] 구현 순서 확인 (프로퍼티 -> init -> 부 생성자 -> 메서드 -> 동반 객체)
- [x] 변수 이름 자료형 X
- [x] 한 함수가 한 가지 기능만 담당(15줄 미만)
- [x] 처음부터 큰 단위의 테스트 작성 X