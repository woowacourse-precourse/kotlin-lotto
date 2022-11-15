## 📄기능 목록!

- 로또 게임 클래스를 만든다.
- Lotto 객체에 companion object를 생성하여 생성자에 접근하도록 한다.
    - 번호를 생성시 오름차순으로 정렬 한다.
    - 또한 getter를 생성하여 numbers값을 받을 수 있도록 한다.
    - 번호 생성시 예외처리를 한다.

- purchaseLotto()를 만든다.
    - 금액을 입력받는다.
        - 입력값 예외처리 한다.redundant
            - 숫자가 아닌 경우 "[ERROR]"를 띄워주기 위한 inputToInt()를 만든다.
            - MONEY_UNIT(1000단위)로 떨어지는지를 확인한다.
                - 아니라면 "[ERROR]"
                - 입력값이 올바르면 구매하고 addLotto()를 호출한다.
    - addLotto()는 myLotto: MutableList<Lotto>에 Lotto객체를 생성하여 add 해준다.
    - myLotto 리스트에 금액만큼 Lotto 객체를 추가한다.
    - 총 금액을 expenditure 변수에 저장한다.

- showMyLotto()로 생성된 로또들의 번호를 출력한다.

- setWinNumbers()를 통해서 winNumbers 값을 입력 받는다.
    - 입력 받은 값을 "," delimiter로 구분하여 반복한다.
    - 입력값 예외 처리를 한다.
        - inputToInt()로 숫자인지 확인하고
        - checkNumberRange() 숫자가 1~45사이에 값인지 확인한다.
        - checkOverlapping() 숫자에 중복이 없는지 확인한다.
        - 6개의 번호를 입력 받았는지 확인하고 정렬하여 값을 저장한다.
- setBonusNumber()를 통해서 bonusNumber 값을 입력 받는다.
    - 입력값 예외 처리를 한다.
    - inputToInt()로 숫자인지 확인하고
    - checkNumberRange() 숫자가 1~45사이에 값인지 확인한다.
    - checkOverlapping() 숫자에 중복이 없는지 확인한다.
- compareLottosWithWinNumber()로 구매한 로또와 당첨 번호를 비교한다.
    - checkNumber()로 숫자를 비교한다.
        - 포인터를 이용해서 정렬된 숫자들을 비교해간다.
        - 번호가 같은 수를 카운트해서 리턴한다.
    - 같은 번호가 3개 이상이라면 winCount()로 등수를 List에 저장한다.
        - winCount()에서는 countToIndex와 보너스 번호의 여부를 가지고 등수를 판단한다.
            - 그리고 등수에 해단하는 index를 반환해준다.
        - winChart[]리스트에 당첨된 등수의 카운트를 올린다.
- 당첨 내역을 출력하고 수익률을 출력한다.
  - printProfit()함수를 통해 출력한다
  - calculateProfit()을 통해 순익을 계산한다.
      - 소수점을 계산하기 위해 10.0을 곱하고 다시 나누어 주었다.
- enumClass 생성
  - 등수별 인덱스와 상금 관리 출력 수정.
- import java.text.DecimalFormat 를 추가하여 출력시 prize에 1,000 단위로 delimeter생성

- 예외처리 테스트 케이스 추가 
  - Lotto 객체에 5개의 숫자가 생성되었을때
  - Lotto 객체에 숫자가 0이 포함되어 있을때
  - Lotto 객체에 숫자가 45를 초과한 값을 가질때
  - winNumber가 잘 못 입력 됬을 때
  - bonus 넘버가 잘 못 입력 됫을 때
  - winNumber나 bonus number가 범위를 초과 했을 때
  - 경계값 분석 테스트 진행.
  