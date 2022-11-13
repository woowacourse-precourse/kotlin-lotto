# 미션 - 로또

## 기능 목록

- [ ] 사용자로부터 로또 구입 금액을 입력받는다. -Buyer#getPurchaseAmount
- [ ] 사용자가 구매하는 로또 개수를 알 수 있다. -Calculation#getPurchaseNumber
- [ ] 사용자로부터 로또 번호 6개를 1~45 범위에서 중복없이 입력받는다. -Buyer#getLottoNumber
  - [ ] 사용자로부터 보너스 번호 1개를 입력받는다. -Buyer#getBonusNumber
- [ ] 사용자가 구매한 로또 개수만큼 로또를 생성한다. -Lotto#generateLotto
  - [ ] 로또 번호를 오름차순으로 정렬한다. -Lotto#sortAscending
- [ ] 사용자의 로또 당첨 내역을 출력한다.
  - [ ] 사용자의 로또와 발행한 로또와 비교하여 몇 개의 수가 일치하는지 알 수 있다. -Calculation#getMatchingNumber
  - [ ] 일치하는 번호 개수에 따른 당첨 내역을 알 수 있다. -Calculation#getWinningLotto
- [ ] 로또 수익과 구매 비용을 통해 수익률을 계산할 수 있다. -Calculation#calcReturnRate
