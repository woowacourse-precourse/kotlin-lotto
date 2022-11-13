# 미션 - 로또

## 기능 목록

- [x] 사용자로부터 로또 구입 금액을 입력받는다. -Buyer#getPurchaseAmount
  - [x] 구매 금액은 1000원 단위로 입력받는다. -Judgment#checkPurchaseAmount
- [x] 사용자가 구매하는 로또 개수를 알 수 있다. -Judgment#getPurchaseNumber
- [x] 로또 당첨번호를 입력받는다. -Seller#getWinningNumber
  - [x] 로또 당첨번호는 1~45 사이 숫자를 입력받는다. -Judgment#checkWinningNumber
  - [x] 로또의 보너스 번호 1개를 입력받는다. -Seller#getBonusNumber
  - [x] 보너스 번호는 1~45 사이 숫자를 입력받는다. -Judgment#checkBonusNumber
- [x] 사용자가 구매한 로또 개수만큼 로또를 생성한다. -Seller#generateLotto
  - [x] 로또 번호를 오름차순으로 정렬한다.
- [ ] 사용자의 로또 당첨 내역을 출력한다. -Lotto#showLottoResult
  - [ ] 사용자의 로또와 발행한 로또와 비교하여 몇 개의 수가 일치하는지 알 수 있다. -Lotto#getMatchingNumber
  - [ ] 일치하는 번호 개수에 따른 당첨 내역을 알 수 있다. -Lotto#getWinningLotto
- [ ] 로또 수익과 구매 비용을 통해 수익률을 계산할 수 있다. -Judgment#calcReturnRate
