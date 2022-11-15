# 💎미션 - 로또

## 📃기능 목록

- [x] 사용자로부터 로또 구입 금액을 입력받는다. - view: Input#buyLotto
  - [x] 구매 금액은 1000원 단위로 입력받는다. - util: Validator#checkPurchaseAmount


- [x] 사용자가 구매하는 로또 개수를 알 수 있다. - util : Validator#getPurchaseNumber


- [x] 로또 당첨번호를 입력받는다. - view: Input#winningNumber
  - [x] 로또 당첨번호는 1~45 사이 숫자를 입력받는다. - util : Validator#checkWinningNumber
  - [x] 로또의 보너스 번호 1개를 입력받는다. - view: Input#bonusNumber
  - [x] 보너스 번호는 1~45 사이 숫자를 입력받는다. - util : Validator#checkBonusNumber


- [x] 사용자가 구매한 로또 개수만큼 로또를 생성한다. - model: LottoMaker#generateLotto


- [x] 사용자의 로또 당첨 내역을 출력한다. - controller: LottoController#showLottoResult
  - [x] 사용자가 구매한 로또와 당첨 번호를 비교하여 몇 개의 수가 일치하는지 알 수 있다. - model: Lotto#getMatchingNumber
  - [x] 5개가 일치했을 때 보너스 번호가 일치하는지 판단할 수 있다. - model: Lotto#matchBonusNumber
  - [x] 일치하는 번호 개수에 따른 당첨 내역을 알 수 있다. - model: Lotto#produceLottoStats


- [x] 로또 수익과 구매 비용을 통해 수익률을 계산할 수 있다. - model: Lotto#calcReturnRate
