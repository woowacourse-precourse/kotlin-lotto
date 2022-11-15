package lotto

import camp.nextstep.edu.missionutils.Console

class BaseData {
    var inputMoney = 0
    var purchasedLotto = mutableListOf<MutableList<Int>>()
    var LottoNum = mutableListOf<Int>()
    var bonusNum = 0

    fun BaseData(){
        inputMoney()
        validInputMoney()
        buyLotto()
        inputLottoNum()
        inputBonus()
        validInputBonus()
    }

    fun inputMoney() {
        println("구입금앱을 입력해 주세요.")
        inputMoney = Console.readLine().toInt()
    }

    fun validInputMoney(){
        if(inputMoney%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.")
        }
    }
    fun countpurchasingVolume(inputMoney: Int): Int {
        var purchasingVolume = inputMoney/1000
        println("${purchasingVolume}개를 구매했습니다.")
        return purchasingVolume
    }

    fun buyLotto() {
        val purchasingVolume = countpurchasingVolume(inputMoney)
        for(i in 1..purchasingVolume){
            purchasedLotto.add(randomLotto())
        }
        purchasedLotto
    }

    fun inputLottoNum() {
        println("당첨 번호를 입력해 주세요.")
        var Lotto = Console.readLine()
        makeLottoNum(Lotto)
    }
    fun makeLottoNum(Lotto:String) {
        for(i in Lotto.replace(" ","").split(",")){
            LottoNum.add(i.toInt())
        }
    }
    fun inputBonus() {
        println("보너스 번호를 입력해 주세요.")
        bonusNum = Console.readLine().toInt()
    }
    fun validInputBonus(){
        if(bonusNum >= 1
            && bonusNum <= 45
        ){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}