package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

/*
2주차 피드백
1. 변수 이름에 자료형, 자료 구조 사용 X
2. 함수 길이 15라인 넘어가지 않게, 넘어가면 분리
3. 핵심 기능에 가까운 부분부터 작게 테스트를 만들어 나간다.
4. else를 지양한다.

ex)
큰 단위의 테스트
숫자 야구 게임을 시작해서 사용자가 숫자를 입력하면, 컴퓨터 숫자와 비교하여 그 결과를 알려준다.

작은 단위의 테스트
사용자의 숫자가 컴퓨터의 숫자와 하나도 일치하지 않으면 낫싱을 출력한다.
사용자의 숫자가 컴퓨터의 숫자와 1개는 일치하고, 위치가 다르면 1볼을 출력한다.
*/

// Enum 클래스 적용해 프로그래밍을 구현한다.
enum class State(val message: String){
    start("구입금액을 입력해 주세요."),
    many("개를 구매했습니다."),
    enterLottoNumber("당첨 번호를 입력해 주세요."),
    enterBonusNumber("보너스 번호를 입력해 주세요."),
    end("당첨 통계");

    //함수 추가 가능함

}

fun howMany() : Int{
    var money = readLine().toInt()
    var answer=money/1000
    return answer
}

fun enterWinningNumber() : List<Int> {
    var userCheck = readLine()
    var winningNumber = mutableListOf<Int>()
    var number=userCheck.split(',')
    for (obj in 0 until number.size){
        // 번호가 중복된 경우 에러 유발해야함
        winningNumber.add(number[obj].toInt())
    }
    return winningNumber
}

fun enterBonusNumber(winningNumbers : List<Int>) : Int {
    var userCheck = readLine().toInt()
    // 보너스 번호가 로또 번호와 같은 경우
    if (winningNumbers.contains(userCheck)){
        throw IllegalArgumentException("[ERROR] 로또 번호와 겹칩니다")
    }
    // 번호 입력을 1~45사이 안한 경우
    else if (userCheck>45 || userCheck<1){
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이")
    }
    return userCheck
}

fun showLottoPaper(cnt : Int) : MutableList<List<Int>> {
    var lottoCollection = mutableListOf<List<Int>>()
    var obj = LottoGames(numbers= listOf(0,0,0,0,0,0))
    for (paper in 0 until cnt){
        lottoCollection.add(obj.pickLottoNumbers())
    }
    return lottoCollection
}

fun compareNumbers(lottoCollection : List<Int>, winningNumber: List<Int>) : Int {
    var count = 0
    for (i in 0 until winningNumber.size){
        if (lottoCollection.contains(winningNumber[i])){
            count+=1
        }
    }
    return count
}


fun main() {
    var cnt = 0
    var lottoNumberCollect = mutableListOf<Int>()
    var bonusNumberCollect = mutableListOf<Int>()
    var obj = LottoGames(numbers= listOf(0,0,0,0,0,0))
    var winningNumber = listOf<Int>()
    var bonusNumber = 0
    var lottoCollection = mutableListOf<List<Int>>()

    //시작
    println(State.start.message)

    //구매 개수
    cnt=howMany()
    println()
    println(cnt.toString()+State.many.message)
    //Lotto 클래스 활용해야함!!!
    lottoCollection=showLottoPaper(cnt)
    for (lotto in 0 until lottoCollection.size){
        println(lottoCollection[lotto])
    }
    println()

    //당첨 번호
    println(State.enterLottoNumber.message)
    winningNumber=enterWinningNumber()
    println()
//    println(winningNumber) // 확인용

    //보너스 번호
    println(State.enterBonusNumber.message)
    bonusNumber=enterBonusNumber(winningNumber)
    println()

    //당첨 통계
    println(State.end.message)
    for (j in 0 until lottoCollection.size){
        compareNumbers(lottoCollection[j], winningNumber)
    }


}
