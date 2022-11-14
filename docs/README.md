## ✅기능 목록

1. 로또 구입 금액 입력 받기  
  1-1 ) String으로 입력받은 구입 금액을 Int로 형변환할 수 없을 경우 -> `IllegalArgumentException` 발생  
2. 로또 번호 고르기
3. 구매한 로또의 개수만큼 로또 번호 배열 출력하기  
  3-1 ) `Randoms.pickUniqueNumbersInRange`를 통해 로또 번호 배열 생성하기  
4. 당첨 번호 입력하기   
  4-1 ) 입력한 번호 중 **범위를 벗어나는 숫자**가 있으면 `IllegalArgumentException` 발생  
  4-2 ) 입력한 값에 **숫자가 아닌 값**이 있으면 `IllegalArgumentException` 발생  
5. 보너스 번호 입력하기  
  5-1 ) 입력한 번호가 **숫자 범위를 벗어나면** `IllegalArgumentException` 발생  
  5-2 ) 입력한 번호가 **당첨 번호와 중복**되면 `IllegalArgumentException` 발생  
  5-3 ) 입력한 값에 **숫자가 아닌 값**이 있으면 `IllegalArgumentException` 발생 
6. 결과 산출하기  
  6-1 ) 당첨 번호 배열과 2에서 선정된 배열을 set으로 변환하고 빼주어 겹치지 않는 번호를 구함  
  6-2 ) 당첨 번호 배열의 size에서 6-1 배열의 size를 뺌 -> 일치하는 번호의 개수를 구할 수 있음  
7. 결과 출력  
8. 문자열에 숫자가 아닌 값이 있는지 판별하는 함수
