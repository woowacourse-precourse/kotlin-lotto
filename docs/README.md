## Lotto 게임 목표

---

1. 로또 구입 금액을 입력 받으면, 금액에 맞는 로또 수량, 번호를 알려준다.
2. 당첨 번호를 입력 받으면 로또 번호와 비교 후, 당첨 내역 및 수익률을 알려준다.

## Lotto 게임 구현 기능 목록

---

1. 로또 구입 금액 입력
    - 조건: 로또 구입 금액은 1,000원 단위
    - 예외 1) 금액이 0 이하일 경우 예외 처리 (ex. 0원, -100원) - Checker#Price#checkPriceUnderZero()
    - 예외 2) 금액이 1,000원 단위로 안 떨어질 경우 예외 처리 (ex. 1,700원) - Checker#Price#checkPriceThousandsUnit()
    - 예외 3) 금액이 숫자 이외의 문자가 있을 경우 예외 처리 (ex. 1000j 원) - Checker#Price#checkPriceInt()


2. 로또 수량 확인
    - 로또 구입 금액을 로또 한장 가격 1,000원으로 나눠서 확인 - LottoGenerator#getLottoCountValue()


3. 로또 번호 확인
    - 로또 번호 범위 1 ~ 45 - Lotto#checkLottoNumberRange()
    - 로또 번호 집단 1개에 중복 제외 - Lotto#checkLottoNumberDuplicated()
    - 로또 번호 집단 1개에 6개 숫자 - Lotto#checkLottoNumberCount()
    - 로또 수량에 맞춰서 중복없이 로또 번호 집단 생성 - LottoGenerator#createLottoNumber()
    - 로또 수량 및 로또 개수 출력 - Stage#stage2


4. 당첨 번호 입력
    - 조건: 당첨 번호 범위 -> 1~ 45, 번호는 중복 제외
    - 당첨 번호는 6개로 구성, ","로 구분 - Stage#stage3
    - 예외 1) 당첨 번호가 1 ~ 45 범위가 아닌 경우 예외 처리 (ex. 0,46,47,48,1,2) - Lotto#checkLottoNumberRange()
    - 예외 2) 당첨 번호가 중복된 경우 예외 처리 (ex. 1,1,1,1,1,1) - Lotto#checkLottoNumberDuplicated()
    - 예외 3) 당첨 번호가 6개가 아닌 경우 예외 처리 (ex. 1,2,3,4,5,6,7) - Lotto#checkLottoNumberCount()
    - 예외 4) 당첨 번호에 숫자가 아닌 문자가 있는 경우 예외 처리 (ex. 1,2,3,4,5,a) - LottoGenerator#checkUserInputLotto()


5. 보너스 번호 입력
    - 조건: 보너스 번호 범위 -> 1~ 45
    - 예외 1) 보너스 번호가 1 ~ 45 범위가 아닌 경우 예외 처리 (ex. 0) - Checker#Bonus#checkBonusValidRange()
    - 예외 2) 보너스 번호가 숫자가 아닐 경우 예외 처리 (ex. a) - Checker#Bonus#checkBonusValidNumber() 
    - 예외 3) 보너스 번호가 당첨 번호와 중복될 경우 예외 처리 - Checker#Bonus#checkBonusValidWithWinning()


6. 로또 번호와 당첨 번호 비교
    - 각 개수가 몇개 일치 하는지 확인 - Calculate#Ranking#countSameNumber()
    - 개수 일치가 5개 인 경우엔, 일치된 숫자에 보너스 숫자가 있는지 확인 - Calculate#Ranking#checkBonusInLotto()
    - 비교로 얻은 순위로 최종 결과값 출력 - Stage#stage5


7. 수익률 계산
    - 당첨 정도에 따른 당첨 금액을 계산 - Calculate#RateOfReturn#calculateRateOfReturn()
    - 당첨 금액과 로또 구입 금액을 이용해서 수익률 계산 - Calculate#RateOfReturn#calculateRateOfReturn()
    - 수익률 출력 - Stage#stage6
   