package lotto

import camp.nextstep.edu.missionutils.Randoms


class RandomNumbers(private val userInput: Int) {
    fun getRandomLottoNumbers(): List<List<Int>> {
        PrintForm().printUserBoughtLottoCount(userInput / LOTTO_EACH_PRICE)
        return makeRandomNumberList(userInput / LOTTO_EACH_PRICE)
    }

    private fun makeRandomNumberList(userBoughtLottoCount: Int): List<List<Int>> {
        val mLottoNumbers = mutableListOf<MutableList<Int>>()
        for (i in 0 until userBoughtLottoCount) {
            mLottoNumbers.add((Randoms.pickUniqueNumbersInRange(1, 45, 6)).sorted() as MutableList)
        }
        printLottoNumbers(mLottoNumbers)
        return mLottoNumbers
    }

    private fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        for (i in lottoNumbers) {
            println(i)
        }
    }

}