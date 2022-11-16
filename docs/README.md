## 기능 목록
- RandomGenerator
  - [x] 로또 발행 시 1 ~ 45까지 중복되지 않는 6개의 숫자를 생성한다. - RandomGenerator#createRandomNumbers()
  - [x] 개수를 받아 그 개수만큼 로또를 생성한다. - RandomGenerator#createRandomlottos()


- Compare
  - [x] 당첨 번호가 몇 개 일치하는지 확인한다. - Compare#checkWinningNumbers()
  - [x] 보너스 번호가 일치하는지 확인한다. - Compare#checkBonusNumber()


- Ranking
  - [x] 번호 일치 개수로 몇 등 인지 확인한다. - Ranking#checkRanking()


- CountRankings
  - [x] 각 등수가 몇 개 인지 확인한다. - CountRankings#countRankings()


- Calculator
  - [x] 총 당첨 금액을 계산한다. - Calculator#sumPrizes()
  - [x] 등수에 따른 당첨 금액을 반환한다. - Calculator#prizeMoney()
  - [x] 구매 금액과 총 당첨 금액을 비교하여 수익률을 계산한다. - Calculator#calculateYield()


- LottoGames
  - [x] 로또 게임을 시작한다. - LottoGames#startGame()
  - [x] 돈을 입력받고 구매한 복권 개수를 출력한다. - LottoGames#purchaseLottos()
  - [x] 등수를 구하고 총 당첨금 및 수익률 계산 - LottoGames#calculateLottos()

## 입춢력 목록
- InputUi
  - [x] 구입금액 입력 받기 - InputUi#inputMoney()
  - [x] 당첨 번호 입력 받기 - InputUi#inputWinningNumbers()
  - [x] 보너스 번호 - InputUi#inputBonusNumber()


- PrintUi
  - [x] 구매 개수 출력 - PrintUi#printPurchaseNum()
  - [x] 로또 목록 출력 - PrintUi#printLottos()
  - [x] 당첨 통계 출력 - PrintUi#printWinningStats()
  - [x] 수익률 출력 - PrintUi#printYield()
  - [x] 입력 요구 메세지 출력 - PrintUi#pleaseInput()

## 예외 처리 목록
- [x] 숫자가 아닌 입력 - String.inputTypeException()
- [x] 숫자가 1000 단위가 아닌 입력 - String.inputUnitException()
- [x] Lotto의 각 숫자가 1 ~ 45 가 아닌 범위 예외 처리
- [x] Lotto의 숫자 중복 예외 처리
- [x] 보너스 숫자가 1 ~ 45 가 아니면 예외 처리
- [x] 로또 입력 시 콤마 이외의 문자 예외처리
- [x] 보너스 숫자와 당첨 숫자 중복 예외처리

## 도메인 테스트 목록
- CalculatorTest
  - [x] 총 당첨 금액 계산 - sumPrizes()
  - [x] 등수로 당첨 금액 확인 - prizeMoney()
  - [x] 수익률 계산 - calculateYield()


- CompareTest
  - [x] 로또와 당첨번호 비교 - checkWinningNumbers()
  - [x] 로또와 보너스 번호 비교 - checkBonusNumber()  


- CountRankingsTest
  - [x] 로또 몇등 몇개 - countRankings()


- RandomGenerator
  - [x] 생성된 로또 개수 확인 - createRandomLottos()


- RankingTest - checkRanking()
  - [x] 6개는 1등
  - [x] 5개에 보너스는 2등
  - [x] 4개에 보너스는 4등


- LottoTest 추가
  - [x] 로또 번호가 1 ~ 45 범위를 넘어가면 예외가 발생한다