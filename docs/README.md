# 구현해야할 기능 정의
1. 로또 구입 금액 입력 받기 (1000원 단위, 1000원으로 나누어떨어지지 않는 경우 예외 처리)
2. 로또 장수를 계산하여 구매 개수 출력하기
3. 2번에서 구한 로또 장수 만큼의 로또 번호 리스트 생성하기
4. 3번에서 구한 리스트 출력하기
5. 당첨 번호 입력 받기 (,로 구분)
- 입력된 번호가 6개 초과되는 경우
- ,를 기준으로 split했을 때 나온 list가 숫자가 아닌 경우
- 번호가 1~45 숫자가 아닌 경우 예외처리 (IllegalArgumentException)
6. 보너스 번호 입력 받기
- 입력된 번호가 숫자가 아닌 경우
- 번호가 1~45 숫자가 아닌 경우 (IllegalArgumentException)
7. 발행 받은 로또 번호와 당첨 번호를 비교하여 당첨 통계 계산하기
8. 당첨 통계 출력하기
9. 수익률 계산하기

예외처리 시 '[ERROR]'로 시작하는 에러 메시지를 출력한다.

# 클래스 정의
## Application
### Field
### Method
- main()
- inputLottoPrice : 로또 구입 금액 입력 받는 메소드
- printLottoCount : 로또 장수 출력하는 메소드
- inputWinningLotto : 당첨 번호와 보너스 번호를 입력 받는 메소드
- printYield : 수익률 출력 메소드
- printWinningStats : 당첨 통계를 출력하는 메소드

## LottoCreator
### Method
- createRandomLotto : 랜덤 로또 번호를 생성하는 메소드
- createRandomLottos : 입력받은 로또 장수 만큼의 로또 번호를 생성하는 메소드

## LottoCalculator
### Method
- calculateLottoCount : 입력받은 로또 구입 금액 -> 로또 장수 계산하는 메소드
- calculateYield : 수익률 계산하는 메소드
- calculateWinningStats : 발행받은 로또 번호와 당첨 번호를 비교하여 당첨 통계를 계산하는 메소드

## Lottos
### Field
- lottos
### Method
- addLotto : Lotto를 lottos에 추가하는 메소드
- printLottos : 로또 번호 리스트를 모두 출력하는 메소드

## Lotto
### Field
- numbers : 로또 번호
### Method
- init
- printLotto : 로또 번호를 출력하는 메소드
- matchLotto : 인자로 받은 로또 번호와 비교하여 몇개 일치하는지 반환하는 메소드

## WinningLotto : Lotto
### Field
- bonusNumber
### Method
- init

## Error
### Method
- RangeError
- sizeError
- typeError