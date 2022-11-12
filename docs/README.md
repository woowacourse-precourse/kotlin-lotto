# 주요 기능 목록
1. 로또 구입 금액 및 당첨 번호(보너스 포함) 입력 기능
2. 입력 검증 기능
3. 당첨 검증 기능
4. 수익률 계산 기능

# 단위 테스트 목록
1. 로또 구입 금액 입력 기능
   - [x] 구입 금액 입력하고 반환 검증
   - [x] 당첨 번호 입력하고 반환 검증
   - [x] 보너스 번호 입력하고 반환 검증
2. 입력 검증 기능
   - [x] 구입 금액 검증
   - [x] 당첨 번호 검증
   - [x] 보너스 번호 검증
3. 당첨 검증 기능
   - [ ] 등급별 당첨 개수 검증
4. 수익률 계산 기능
   - [ ] 총 수익률 계산(자릿수까지) 검증

# 클래스 분리
1. 로또 클래스(Lotto)
   - 숫자 6자리 배열을 가지고 있음(기본 제공)
   - 각기 다른 숫자를 만족하는지 검사(require로 대체)
   - 랜덤 배열과 당첨 번호 비교 함수(compareOriginal)
   - 보너스 번호를 포함한 비교 함수(compareBouns)

2. 수익률 연산 및 결과 출력하는 클래스(Lottery)
   - 당첨 등급 카운팅 맵(winningCounter)
   - 당첨 번호 배열(lotteryNumbers)
   - 랜덤 로또 배열(quickPicks)
   - 보너스 번호(bounsNumber)
   - 구입 금액(purchase)
   - 총 수익(income)
   - 수익률(incomeRatio)
   - 구매 개수 출력 함수(printTicketNumbers)
   - 랜덤 배열 출력 함수(printQuickPick)
   - 당첨 내역 출력 함수(printWinnings)
   - 로또 구입 금액 입력 함수(getAmount)
   - 당첨 번호 입력 함수(getLotteryNumbers)
   - 랜덤 로또 생성 함수(getQuickPicks)
   - 보너스 번호 입력 함수(getBounsNumber)
   - 수익 계산 함수(getIncomeRatio)
   - 수익 출력 함수(printIncomeRatio)

3. Enum 클래스들
   - 당첨 등급에 따른 금액 클래스(WinningAmonut)
   - 로또 숫자 번호 범위 클래스(NumberRange)
   - 로또 가격 클래스(Price)
