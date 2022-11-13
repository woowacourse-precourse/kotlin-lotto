package lotto

//기능 목록
/*
1. 로또 구입 금액을 입력 받는다.
1. 입력 받은 금액은 1,000원 단위로 나누어 발행할 로또 수량을 계산한다.
2. 당첨 번호를 입력 받는다.
1. 당첨 번호 6개를 입력 받는다.
2. 당첨 번호는 쉼표를 기준으로 구분한다.
3. 보너스 번호를 입력 받는다.
4. 1~45까지의 숫자 중 중복되지 않는 6개의 숫자를 뽑는다.
1. 1.에서 계산한 로또 발행 수량에 따라, 1번 발행시 6개의 숫자를 뽑는다.
5. 3.에서 발행한 로또 번호를 보여준다.
1. 몇 개를 구매했는지 발행 번호 출력 전에 보여준다. ex)8개를 구매했습니다.
2. 발행 번호는 오름차순으로 정렬하여 보여준다.
6. 당첨 내역을 출력한다.
1. 몇 개 일치하는지 나타낸다.
7. 수익률을 출력한다.
1. 소수점 둘째 자리에서 반올림한 것을 출력한다.
 */

fun main() {
//    TODO("프로그램 구현")

}

// 1. 로또 구입 금액 입력 받기
fun getLottoPrice() : Int? {
    println("구입금액을 입력해 주세요.")
    val lottoPrice = readLine()?.toInt()
    //구입 금액 입력 받을 때 생길 수 있는 예외 사항 처리 필요
    return lottoPrice
}

// 2. 로또 수량 계산
fun getLottoCount(lottoPrice : Int) : Int{
    val lottoCount = lottoPrice / 1000
    //만약 나누어지지 않을 시에 발생하는 예외 사항 처리 필요
    return lottoCount
}

//3. 당첨 번호 입력 받기
fun getWinNums() : String? {
    println("당첨 번호를 입력해 주세요.")
    val winNums = readLine()
    //당첨 번호를 양식에 맞게 입력하지 않았을 때의 예외 사항 처리 필요
    return winNums
}
