# [프리코스 3주차 미션 - 로또]

![Generic badge](https://img.shields.io/badge/precourse-Kotlin-purple.svg)
![Generic badge](https://img.shields.io/badge/precourse-week3-red.svg)

## 📜 기능목록
### 로또 번호 발행
### 당첨번호 입력 받기
- 당첨번호는 쉼표(,)로 구분

### 보너스번호 입력 받기
### 당첨 내역 확인
- 사용자가 구매한 로또 번호와 당첨 번호를 비교

### 수익률 출력
- 수익률 = (수익 / 로또 구매비용) * 100
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. `100.0%`, `51.5%`, `1,000,000.0%`)

### 구입 금액 입력값 예외처리
- `IllegalArgumentException` 발생 시킨 뒤, `[ERROR]`로 시작하는 에러 메시지를 출력 후 종료
- (예외 상황 1) 1000원으로 나누어 떨어지지 않는 경우
- (예외 상황 2) 숫자 이외의 값을 입력

### 당첨번호, 보너스번호 입력값 예외처리
- `IllegalArgumentException` 발생 시킨 뒤, `[ERROR]`로 시작하는 에러 메시지를 출력 후 종료
- (예외 상황 1) 번호 구분을 쉼표(,)로 하지 않은 경우
- (예외 상황 2) 숫자 이외의 값을 입력