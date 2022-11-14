package lotto

class Consumer(private val money: Int) {
    val myLotto = mutableListOf<List<Int>>()

    init {
        require(money % 1000 == 0) { println("[ERROR] 1000원 단위가 아닙니다.") }
        require(money >= 1000) { println("[ERROR] 돈이 부족합니다") }
    }

    fun buyLotto(){
        for(lottoCount in 0 until money/1000){
            val lottoList = LottoShop().createLotto()
            myLotto.add(lottoList)
        }
    }

    fun compareLotto(winningNumbers : Lotto, bonusNumber : Int) : List<Int>{
        return LottoCalculator(myLotto, winningNumbers,bonusNumber).calculateLotto()
    }
}