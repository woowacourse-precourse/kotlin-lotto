# 로또 게임

## 기능 목록
- [ ] 로또 게임을 시작한다. - LottoGame#gameStart()
- [x] 로또 구입 금액을 잘못 입력한 경우 예외 처리한다. - Exception#inputTypeException()
- [x] 로또 구입 금액을 잘못 입력하거나 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. - Exception#inputMoneyException()
- [x] 로또 구입 금액을 입력하면 1000원당 1장, 구입 금액에 해당하는 만큼 로또를 생성한다. - LottoShop#buyLotto()
- [x] 구입 금액에 만큼 살 수 있는 로또의 개수를 확인하다.- LottoShop#cntLotto()
- [x] 1부터 45까지 서로 다른 임의의 수 6개의 숫자를 생성한다. - LottoShop#createRandomLotto()
- [x] 당첨 번호와 보너스 번호를 구한다. - LottoWin#winLotto()
- [x] 당첨 번호와 보너스 번호를 저장한다. - LottoWin#LottoWinBall
- [x] 당첨 번호는 중복되지 않는 숫자 6개를 입력 받는다. - LottoGame#inputWinningNumber()
- [x] 당첨 번호와 중복되지 않는 보너스 번호 1개를 입력 받는다. - LottoGame#inputBonusLotto()
- [x] 당첨 번호를 잘못 입력한 경우 예외 처리한다. - Exception#inputLottoNumberTypeException()
- [x] 당첨 번호를 잘못 입력하거나 1부터 45 사이에 번호가 아닌 경우 예외 처리한다. - Exception#inputLottoNumberException
- [x] 당첨 번호의 개수가 잘못 입력되었거나 중복되었을 경우 예외 처리한다. - Exception#inputWinningNumberException
- [x] 보너스 번호가 당첨 번호와 중복되었을 경우 예외 처리한다. - Exception#inputWinningBonusNumberException
- [x] Lotto의 Numbers를 출력한다.  - Lotto#getNumbers()
- [x] 당첨금과 당첨을 하기위한 개수를 저장한다. - LottoCheck#LottoReward
- [x] 당첨은 1등부터 5등까지 있다. 로또 번호와 당첨 번호를 비교할 수 있다. - LottoCheck#compareLotto()
    - [x] 몇개의 숫자가 같은지 알 수 있다. - LottoCheck#correctLotto()
    - [x] 6개의 번호가 일치하면 1등이다.
    - [x] 5개의 번호와 보너스 번호가 일치하면 2등이다.
    - [x] 5개의 번호가 일치하면 3등이다.
    - [x] 4개의 번호가 일치하면 4등이다.
    - [x] 3개의 번호가 일치하면 5등이다.
- [x] 사용자의 로또 번호가 몇등인지 확인한다. - LottoCheck#rankLotto()
- [x] 저장한 당첨 번호를 리스트로 변환시킨다. - LottoCheck#lottoWinNumbers()
- [x] 저장한 보너스 번호를 정수형으로 변환시킨다. - LottoCheck#rankLotto()
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. - LottoBank#yieldLotto()
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## 기능 요구 사항
로또 게임 기능을 구현해야 한다.

로또 게임은 아래와 같은 규칙으로 진행된다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.