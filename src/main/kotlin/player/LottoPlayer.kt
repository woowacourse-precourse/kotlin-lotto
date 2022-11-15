package player

import enterprise.LOTTO_MAX_GRADE
import enterprise.LOTTO_MIN_GRADE
import enterprise.LOTTO_NUM_RANGE_END
import enterprise.LottoEnterprise
import enterprise.SameLottoResult
import enterprise.lottoPrize
import lotto.Lotto
import market.LottoMarket
import util.printLottoEarningsRate
import util.printLottoGradeCountToMessage
import winlotto.WinLotto

class LottoPlayer(
    private val lottoEnterprise: LottoEnterprise,
    private val lottoMarket: LottoMarket,
) {
    private lateinit var lotties: List<Lotto>
    private var payMoney: Int = 0

    /*
    * 로또 구매
    * */
    fun buyLotties() {
        payMoney = lottoMarket.payMoney()
        lotties = lottoMarket.sellLotties(payMoney)
    }

    /*
    * 로또들 맞춰보기
    * */
    fun matchLotties() {
        val winLotto = lottoEnterprise.getWinLotto()
        val lottoGrades = getSameLottiesResult(winLotto, lotties).map { it.parseSameResultToGrade() }
        val gradeCounts = getGradeCounts(lottoGrades)
        showLottoResults(gradeCounts)
    }

    /*
    * 로또 결과 보여주기
    * */
    private fun showLottoResults(gradeCounts: IntArray) {
        showLottoResultGrade(gradeCounts)
        showLottoEarningRate(gradeCounts)
    }

    /*
    * 로또 수익률 출력
    * */
    private fun showLottoEarningRate(gradeCounts: IntArray) {
        val lottoPrizeSum = getLottoPrizeSum(gradeCounts)
        printLottoEarningsRate(lottoPrizeSum, payMoney)
    }

    /*
    * 로또 등수별 결과 출력
    * */
    private fun showLottoResultGrade(gradeCounts: IntArray) {
        for (grade in LOTTO_MAX_GRADE downTo LOTTO_MIN_GRADE) {
            printLottoGradeCountToMessage(grade, gradeCounts[grade])
        }
    }

    /*
    * 로또 등수별 상금 합 가져오기
    * */
    private fun getLottoPrizeSum(gradeCounts: IntArray): Long {
        return gradeCounts.mapIndexed { grade, count ->
            lottoPrize[grade] * count
        }.sum()
    }

    /*
    * 로또별 같은 숫자 개수 가졍괴
    * */
    private fun getSameLottiesResult(
        winLotto: WinLotto,
        lotties: List<Lotto>,
    ): List<SameLottoResult> {
        return List(lotties.size) {
            matchLotto(lotties[it], winLotto)
        }
    }

    /*
    * 로또 등수별 개수 가져오기
    * */
    private fun getGradeCounts(lottoGrades: List<Int>): IntArray {
        val gradeCounts = IntArray(LOTTO_MAX_GRADE + 1)
        lottoGrades.forEach { grade ->
            gradeCounts[grade]++
        }
        gradeCounts[0] = 0
        return gradeCounts
    }

    /*
    * 로또 하나 맞춰보기
    * */
    private fun matchLotto(
        lotto: Lotto,
        winLotto: WinLotto,
    ): SameLottoResult {
        var lottoSameCount = 0
        var isBonusSame = false
        val lottoNumbers = lotto.getNumbers()
        val winLottoNumbers = winLotto.getNumbers()
        val used = getCheckNumList(winLottoNumbers)

        lottoNumbers.forEach {
            if (used[it]) {
                if (winLottoNumbers[winLottoNumbers.lastIndex] == it) isBonusSame = true
                else lottoSameCount++
            }
        }
        return SameLottoResult(lottoSameCount, isBonusSame)
    }

    /*
    * 나온 숫자 체크한 리스트 가져오기
    * */
    private fun getCheckNumList(numbers: List<Int>): BooleanArray {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        numbers.forEach {
            used[it] = true
        }
        return used
    }
}