# 작동 로직 
1. 로또 구입 금액 입력
2. 금액/1000 해서 발행 개수 구하기
3. 구매 개수만큼 랜덤 생성
4. 당첨되게 할 번호는 사용자가 입력
5. 당첨 통계 출력



- Lotto class 
  - 

# 예외 상황
-[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

# 요구 사항
- indent 2까지 허용 -> 함수 쪼개기
- 함수 15라인 제한
- else 지양
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.

# 라이브러리
- [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    - 정수형 변환 !!.toInt()