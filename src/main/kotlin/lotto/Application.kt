package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
    createLottoList()
}

fun buyLotto() : List<Int> {
    print("구매 금액을 입력해 주세요.")
    var userInput : Int? = readLine()!!.toIntOrNull()
    var tmp : List<Int> = listOf()

    if(!userInputCheck(userInput)){
        println("유효하지 않은 입력입니다.")
    }

    while (userInput!! > 0){
    }

    if(!setCheck(inputs)){
        println("유효하지 않은 입력입니다.")
    }


    return tmp
}

fun userInputCheck(userInput: Int?): Boolean {

}

fun createOneLotto() : Lotto {
    // 새로운 랜덤한 로또 용지 하나를 만드는 함수

    var newLotto = mutableSetOf<Int>()
    while (newLotto.size < 6)
        newLotto+= Randoms.pickNumberInRange(1, 9)
    return ListToLotto(newLotto.toList())
}

fun ListToLotto(lottoInList: List<Int>) : Lotto {
    return Lotto(lottoInList)
}

fun createLottoList(howMany : Int) : List<Lotto>{
    // 로또 용지의 전체 리스트를 리턴함
    var newLottoList: List<Lotto> = listOf()

    for(i: Int in 0 until  howMany){
        val aLotto= createOneLotto()
        newLottoList += aLotto
    }
    return newLottoList
}