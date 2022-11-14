## 🎯 UseCase
### 성공시나리오
1. 사용자가 로또를 구매할 금액을 입력한다.
2. 로또 시스템은 구매한 개수만큼 랜덤으로 로또 번호를 생성한다.
3. 사용자가 로또 번호 6개를 입력한다.
4. 사용자가 보너스 번호를 입력한다.
5. 시스템은 사용자가 입력한 번호들과 생성된 로또 번호를 비교하여 결과를 생성한다.
6. 시스템은 결과와 총수익률을 출력해준다. 


### 대안시나리오
#### 1a. 사용자가 잘못된 형식을 입력한 경우
1. [Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 1b. 사용자가 1000원 단위로 값을 내지 않은 경우
1. 사용자가 낸 가격을 1000원 단위로 나눈다.
2. 나눈 몫만큼 로또를 구매하고 나머지는 거슬러준다.

#### 1c. 사용자가 낸 가격이 부족한 경우
1. [Error]로 금액이 부족하다고 출력해주고 IllegalArgumentException을 발생시킨다.

#### 3a. 사용자가 겹치는 로또 번호를 입력하는 경우
1. [Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 3b. 사용자가 6개를 입력하지 않는 경우
1.[Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 3c. 사용자가 1~45 범위의 값을 입력하지 않는 경우
1.[Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 3d.사용자가 잘못된 형식을 입력한 경우
1. [Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 4a. 사용자가 로또 번호와 겹치는 보너스 번호를 입력하는 경우
1. [Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 4b. 사용자가 1개를 입력하지 않는 경우
1.[Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 4c. 사용자가 1~45 범위의 값을 입력하지 않는 경우
1.[Error]를 출력해주고 IllegalArgumentException을 발생시킨다.

#### 4d.사용자가 잘못된 형식을 입력한 경우
1. [Error]를 출력해주고 IllegalArgumentException을 발생시킨다.



## 📝기능 구현 리스트
1. inputMoney : 사용자에게 구매 금액을 입력받는 기능[O] - Class LottoVendingMachine
2. isNumInt : 사용자가 입력한 금액이 정수형이 맞는지 체크하는 기능[O] - Class Util
3. countMoney : 사용자가 입력한 금액을 계산하여 생성할 로또 개수를 반환하는 기능[O] - Class LottoVendingMachine
   1. isEnoughMoney : 사용자가 입력한 금액이 충분한지 체크하는 기능[O] 
   2. isMoney1000 : 사용자가 입력한 금액이 1000원 단위인지 검사하고 거스름돈을 정의해주는 기능[O]
4. makeLottoNum : 원하는 만큼 로또를 생성하여 반환해주는 기능[O] - Class LottoNumGenerator
5. inputLottoNum : 사용자에게 로또 번호를 입력받는 기능[O] - Class LottoGame
6. isRightForm : 사용자가 입력 형식과 자료형을 맞췄는지 검사하는 기능[O] -Class Util
7. isRightNumCount : 사용자가 맞는 개수를 입력했는지 검사하는 기능[O] - Class Util
8. isRightRange : 사용자가 1~45 범위의 값을 입력했는지 검사하는 기능[O]- Class Util
9. isOverlap : 로또 번호가 중복되는 경우[O] - Class Util
10. inputBonusNum : 사용자가 보너스 번호를 입력받는 기능[O] - Class LottoGame
11. checkBonusNum : 사용자가 보너스 번호를 맞게 입력했는지 검사하는 기능[O] -Class Util
12. compareLottoNum : 로또 번호와 당첨 번호를 비교해서 결과를 생성하는 기능[O] - Class Calculator
13. calculateYield : 수익률을 계산해주는 기능[O] - Class Calculator 
14. printResult : 당첨 현황과 수익률을 출력해주는 기능[ ] - Class LottoGame 
15. playLottoGame : 로또 게임 실행[ ] - Class LottoGame
16. changeInputToLotto : 로또 입력을 리스트로 바꿔주는 기능 [O] - Util
17. playGame : 로또 게임을 진행하는 기능 [ ] - LottoGame
18. checkLotto : 로또번호와 당첨 번호를 비교하는 기능 [O] - Class Calculator

## 📦️ 생성 클래스
1. Application : 메인 클래스
2. LottoGame : 로또 게임이 진행되는 클래스
3. Lotto : 로또 번호 클래스
4. Bonus : 보너스 번호 클래스
5. Util : 각종 입력들이 형식에 맞고 오류가 없는지 체크하는 클래스
6. LottoVendingMachine : 사용자에게 돈을 받고 로또를 판매하는 클래스
7. LottoNumGenerator : 로또 번호를 생성하는 클래스
8. Calculator : 로또 게임 결과를 계산하는 클래스