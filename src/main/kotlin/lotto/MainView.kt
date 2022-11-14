package lotto

//UI 로직 포함하는 클래스 생성
class MainView {

    // 1. 로또 구입 금액 입력 받기
    fun getLottoPrice() : Int? {
        println("구입금액을 입력해 주세요.")
        val lottoPrice = readLine()?.toInt()
        //구입 금액 입력 받을 때 생길 수 있는 예외 사항 처리 필요
        return lottoPrice
    }

    // 2. 당첨 번호 입력 받기
    fun getWinNums() : String? {
        println("당첨 번호를 입력해 주세요.")
        val winNums = readLine()
        //당첨 번호를 양식에 맞게 입력하지 않았을 때의 예외 사항 처리 필요
        return winNums
    }

    fun showLottoNums(lottoNums : Int){

        val lottos = Lotto()

        println(lottoNums.toString() + "개를 구매했습니다.")
        for(i in 0..lottoNums){

        }
    }

}