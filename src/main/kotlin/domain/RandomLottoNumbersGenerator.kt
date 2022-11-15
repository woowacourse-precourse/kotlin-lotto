package domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumbersGenerator(purchaseAmount: Int) {
    private val randomLottoes = mutableListOf<List<Int>>()

    init{
        createRandomLottoNumbers(purchaseAmount)
        showRandomLottoes()
    }

    /**
     * 구입 금액에 따라 랜덤 로또 번호를 뽑는 함수
     */
    fun createRandomLottoNumbers(purchaseAmount: Int){
        println("\n${purchaseAmount / 1000}개를 구매했습니다.")
        for (index in 0 until purchaseAmount/1000){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            randomLottoes.add(numbers.sorted())
        }
    }

    /**
     * 뽑은 로또 번호들을 출력해주는 함수
     */
    fun showRandomLottoes(){
        for (index in randomLottoes.indices){
            println(randomLottoes[index])
        }
    }

    /**
     * getter 함수
     */
    fun getRandomLottoes(): List<List<Int>> {
        return randomLottoes
    }
}
