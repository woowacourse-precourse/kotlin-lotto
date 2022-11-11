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