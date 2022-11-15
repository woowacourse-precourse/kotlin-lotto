# 미션 - 로또

## 기능 목록
### 1. 구매
- 구입 금액을 입력받는다.
  - 천원 단위로 금액을 입력받으며, 이 외의 경우 에러 문구를 출력한다.
    - 정해진 형태 (정수) 이외의 값을 입력받은 경우 (공백 포함)
    - 천(1000) 으로 나누어 떨어지지 않는 경우
    - 양의 값이 아닌 경우


- 입력받은 금액만큼의 로또 구매 문구를 출력한다.


### 2. 로또 번호
- 천원 당 로또 번호 한 개를 발행한다.
  - 로또 번호는 1~45의 랜덤한 숫자 6개로 이루어진다.


- 발행된 로또 번호는 오름차순 정렬하여 출력한다.


### 3. 당첨 번호
- 당첨 번호와 보너스 번호를 입력받는다.
  - 당첨 번호
    - 1부터 45까지 중복되지 않는 숫자 6개를 입력받으며, 이 외의 경우 에러 문구를 출력한다.
      - 정해진 입력 형식 (쉼표 구분) 에 맞지 않는 경우
      - 정해진 형태 (정수) 이외의 값을 입력받은 경우 (공백 포함)
      - 1부터 45 이외의 수를 입력받은 경우
      - 정해진 개수에 맞지 않는 경우
      - 중복된 숫자가 포함된 경우

  - 보너스 번호
    - 1부터 45까지 당첨 번호와 중복되지 않는 숫자 1개를 입력받으며, 이 외의 경우 에러 문구를 출력한다.
      - 정해진 형태 (정수) 이외의 값을 입력받은 경우 (공백 포함)
      - 1부터 45 이외의 수를 입력받은 경우
      - 당첨 번호와 중복된 경우



### 4. 당첨
- 당첨 기준에 따라 당첨 내역과 수익률을 출력한다.
  - 당첨은 로또 번호의 순서에 상관없이 당첨 번호와의 일치 여부만 따진다.
