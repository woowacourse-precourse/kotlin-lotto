# 미션 - 로또
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## 기능 순서
```
01. <입력> 1,000원 단위로 로또 구입 금액
02. <출력> 발행한 로또 수량 및 번호 / 오름차순
03. <입력> 당첨 번호 / 쉼표(,)로 구분
04. <입력> 보너스 번호
05. <출력> 당첨 내역
06. <출력> 수익률
```
---
## 기능 목록
### `LottoInputOutput` _클래스_
  - [x] `lottoPurchaseAmount` : 구입 금액 입력
  - [x] `lottoCount` : 구매한 갯수
  - [x] `lottoLists` : 로또 목록 출력
  - [x] `lottoAnswer` : 당첨 번호 입력
  - [x] `lottoBonus` : 보너스 번호 입력
  - [ ] `lottoStats` : 당첨 통계
  - [ ] `lottoRateOfReturn` : 수익률

### `LottoLogic` _클래스_
  - [x] `lottoGenerator` : 로또 생성기
  - [x] `lottoPurchaseAmount` : 로또 구입 금액
  - [x] `lottoCreateLists` : 구입한 수만큼 로또 생성
  - [ ] `lottoRateOfReturn` : 수익률 계산

### `LottoStats` _클래스(Enum)_
  - [x] `lottoMatchLists` : 당첨 통계
  - [x] `lottoMatchList` : 로또 당첨 여부
  - [x] `findRank` : 순위 찾기

### `Lotto` _클래스_
  - [x] `lottoAnswer` : 로또 당첨 번호
  - [x] `lottoBouns` : 로또 보너스 번호
---
## 프로그래밍 요구 사항
  - [x] `ApplicatinTest`의 모든 테스트가 성공하는가?
  - [x] indent depth가 3이 넘지 않는가?
  - [ ] 함수가 한 가지 일만 하는가?
  - [x] 기능 목록이 정상 동작하는가?
### 추가된 요구 사항
  - [ ] 함수의 길이가 15라인을 넘지 않는가?
  - [x] else를 지양하고 있는가?
  - [x] Enum클래스를 적용했는가?
  - [x] 도메인 로직에 단위 테스트를 구현했는가?
### 라이브러리
  - [x] `Randoms` API를 사용하는가?
  - [x] `Console` API를 사용하는가?
### Lotto 클래스
  - [x] 주어진 `Lotto` 클래스의 요구사항을 지켰는가?