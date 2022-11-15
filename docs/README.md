## 기능 목록

### Business Logic
- [x] 금액을 받는다. 해당 금액이 유효한 금액인지 판단 Money:#validateMoney()
  - [ERROR] 예외처리 필요
- 로또를 구매하기 위한 금액에 맞게 로또 갯수 구하는 기능 (로또 가격 1,000)
  - [x] 금액을 1,000 단위로 나누는 기능 : Publisher#generateLottery()
  - [x] LottoMachine 에게 로또 발행 협력하기 Publisher#operateMachine()
- 로또 갯수에 따라서 로또 랜덤값 발행 (정렬 필요)
  - `pickUniqueNumbersInRange()` 를 사용하여 랜덤 값 발행
    - [x] 중복 없이 6자리 값 구하기 : LotteryMachine#operate()
- [x] 당첨 번호와 보너스 번호를 입력 받아서 유효한 한지 판단 :
    - [x] 보너스 번호 유효성 검사 WinningLottery#validateBonusNumber
    - [x] 당첨 번호 유효성 검사 WinningLottery#validateNumbers
    - [ERROR] 예외처리 필요
- 구매한 로또 번호와 당첨 번호를 비교하는 기능
  - [x] 로또 하나씩 6자리 비교하기. 비교하고 일치 갯수 체크 LotteryChecker#checkLotteryNumber()
    - [x] 로또 하나씩 비교하고 카운트 하고 보너스 일치여부 확인 LotteryChecker#matchLottoNumbers()
    - [x] 만약 5개 일치한 경우만, 보너스 숫자 일치 여부 확인하기 Rank#valueOf()
    - [x] 보너스 숫자 일치 여부와 맞는 갯수를 가지고 당첨 등수 확인 Rank#valueOf()
    - [x] 수익률을 구하기 위해 당첨 등수에 대한 갯수 저장 LotteryChecker#addCount()

### 예외처리 (Exception)
- 입출력 관련 IllegalArgumentException 발생 (단, [ERROR] 로 시작)
- 사용자 입력 받은 `구입 금액`이 1,000 단위로 나눠 떨어지지 않을 시 예외처리
  1. [x] 숫자가 아닐 경우 예외처리
  2. [x] 1,000 으로 나누었을 시에 나머지가 존재할 경우 예외처리
- 사용자 입력 받은 `당첨 번호` 예외처리
  1. [x] , 으로 나눈 뒤, 리스트에 담을 때 숫자가 아닐 경우 예외
  2. [x] 숫자가 1~45 사이가 아닐 경우 예외처리
  3. [x] 숫자가 6개가 아닐 경우 예외처리
  4. [x] 중복이 있을 경우 예외처리
  5. [x] 끝에 반점(,) 이 들어가는 경우
- 사용자 입력 받은 `보너스 번호` 예외처리
  1. [x] 숫자가 아닐 경우 예외처리
  2. [x] 1~45 내의 숫자가 아닐 경우 예외처리
