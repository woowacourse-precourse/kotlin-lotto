# 미션 - 로또
- 로또를 발행해 당첨 여부에 따른 결과를 출력해주는 로또 게임 기능을 구현한다.

## 구현 기능 목록

- [X] 로또 구입 금액을 입력받는다. - LottoView#getInputMoney()
    - **예외)** 1,000원으로 나누어지지 않을 경우 예외 처리한다.
    - **예외)** 0원일 경우도 예외 처리한다.
- [X] 발행할 로또의 개수를 구한다. - LottoMoney#getPurchaseLottoAmount()
- [X] 로또를 투입된 금액만큼 생성한다. - LottoGenerator#issueLottos()
    - [X] **예외)** 1~45 이외의 숫자나 숫자 이외의 값이 입력될 경우 예외 처리한다. - Lotto#hasLottoNumberValidRange()
    - [X] **예외)** 중복되는 숫자가 있을 시 예외 처리한다. - Lotto#isLottoNumberDuplicated()
- [X] 당첨 번호를 입력받는다. - LottoView#inputWinningLottoNumbers()
    - **예외)** 1~45이외의 숫자나 숫자 이외의 값이 입력될 경우 예외 처리한다.
    - **예외)** 중복되는 숫자가 있을 시 예외 처리한다.
- [X] 보너스 번호를 입력받는다. - LottoView#inputBonusNumber()
- [X] 입력받은 당첨, 보너스 번호로 당첨 로또를 생성할 수 있다. - WinningLotto()
    - [X] **예외)** 당첨번호 중 보너스 번호와 중복이 있을 시 예외 처리한다. - WinningLotto#isValidBonusNumber()
- [X] 사용자가 발행한 로또와 당첨 로또를 비교하여 등수를 반환해 준다. - Lottos#matchingLottoNum()
- [X] 각 등수마다 당첨된 로또의 개수를 알 수 있다. - LottoWinResult#getLottoResult()
- [X] 당첨 여부에 따른 결과를 출력한다. - LottoView#printResult
- [X] 수익률을 출력한다. - LottoView#printYieldRate