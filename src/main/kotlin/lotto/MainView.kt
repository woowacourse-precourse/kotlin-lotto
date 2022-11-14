package lotto

import camp.nextstep.edu.missionutils.Randoms

//UI 로직 포함하는 클래스 생성
class MainView {

    // 1. 로또 구입 금액 입력 받기
    fun getLottoPrice() : Int? {
        println("구입금액을 입력해 주세요.")
        val lottoPrice = readLine()?.toInt()
        //구입 금액 입력 받을 때 생길 수 있는 예외 사항 처리 필요
        return lottoPrice
    }

    fun showLottoNums(lottoNums : Int, createdLottos : List<List<Int>>){

        println(lottoNums.toString() + "개를 구매했습니다.")
        for(i in 0..lottoNums){
            println(createdLottos[i])
        }
    }

    // 2. 당첨 번호 입력 받기
    fun getWinNums() : String? {
        println("당첨 번호를 입력해 주세요.")
        val winNums = readLine()
        //당첨 번호를 양식에 맞게 입력하지 않았을 때의 예외 사항 처리 필요
        return winNums
    }

    // 3. 보너스 번호 입력 받기
    fun getBonusNum(): Int? {
        println("보너스 번호를 입력해 주세요.")
        //보너스 번호가 양식에 맞게 입력되지 않았을 때의 예외 사항 처리 필요
        return readLine()?.toInt()
    }

    fun winTotal(winCount : List<Int>, earningRate : String){
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - " + winCount[0] + "개")
        println("4개 일치 (50,000원) - " + winCount[1] + "개")
        println("5개 일치 (1,500,000원) - " + winCount[2] + "개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winCount[3] + "개")
        println("6개 일치 (2,000,000,000원) - " + winCount[4] + "개")
        println("총 수익률은$earningRate%입니다.")
    }

}