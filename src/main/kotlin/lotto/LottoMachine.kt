package lotto

import camp.nextstep.edu.missionutils.Randoms

private const val LOTTO_SIZE = 6

enum class Rank(var prize: Int) {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);
}
/*
로또 기계 클래스, 필드로는 출력을 담당하는 LottoPrinter 객체,
입력을 담당하는 LottoConsole 객체,
사용자의 구매 정보를 담은 User 객체,
당첨번호, 보너스 번호, 당첨 결과를 담을 리스트가 있다.
해당 클래스에서 로또 프로그램의 연산을 담당한다.
 */

class LottoMachine(private val printer: LottoPrinter, private val console: LottoConsole) {
    private lateinit var user: User //사용자 정보
    private lateinit var winningNum: Lotto // 당첨 번호
    private var bonusNum: Int             // 보너스 번호
    private val lottoResult: MutableList<Int> // 결과를 담을 리스트

    init {
        this.bonusNum = 0
        this.lottoResult = mutableListOf<Int>(0, 0, 0, 0, 0)
    }


    fun inputAmount(): Int = console.inputAmount()
    fun printHowMuchLotto() = printer.printIntroMsg()
    fun printMyLottoTickets() {
        printer.printTicketsCount(user.amount)
        printer.printMyTickets(user)
    }

    fun inputWinningNum() {
        this.winningNum = console.inputWinningNumbers()
    }

    fun inputBonusNum() {
        this.bonusNum = console.inputBonusNum(winningNum)
    }

    fun makeRandomNumber(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers.sorted())
    }

    fun makeUserLottoTickets(amount: Int): List<Lotto> {
        val lottoTicketCount = amount / 1000
        val lottoTickets = mutableListOf<Lotto>()

        for (times in 0 until lottoTicketCount) {
            lottoTickets.add(makeRandomNumber())
        }
        return lottoTickets
    }

    fun initializeUser(amount: Int, lottoTickets: List<Lotto>) {
        this.user = User(amount, lottoTickets)
    }

    fun checkResult() { // 구매한 로또 전체를 당첨 번호와 비교하여 몇등인지 체크
        var correctCount: Int
        for (myLotto in user.myLottoTickets) {
            correctCount = checkResultOneByOne(myLotto)

            checkMyRank(correctCount)
        }
    }

    fun checkResultOneByOne(lotto: Lotto): Int { //로또 한장을 당첨 번호와 비교
        var correctCount = 0
        for (numbers in 0 until LOTTO_SIZE) {
            if (lotto.getNumbers().contains(winningNum.getNumbers()[numbers])) {
                correctCount += 1
            }
        }
        if (correctCount == 5) {
            checkBonusNum(lotto)
        }
        return correctCount
    }

    fun checkMyRank(correctCount: Int) { //몇등인지 체크
        when (correctCount) {
            3 -> lottoResult[4] += 1
            4 -> lottoResult[3] += 1
            6 -> lottoResult[0] += 1
        }
    }

    fun checkBonusNum(lotto: Lotto) { //5개까지 맞은 경우 보너스 번호 비교
        if (lotto.getNumbers().contains(bonusNum)) {
            lottoResult[1] += 1
        }
        if (!lotto.getNumbers().contains(bonusNum)) {
            lottoResult[2] += 1
        }
    }

    fun calculatePrize(): Double { //수익률 계산
        var wholePrize: Long = 0
        wholePrize += (Rank.FIRST_PRIZE.prize * lottoResult[0])
        wholePrize += (Rank.SECOND_PRIZE.prize * lottoResult[1])
        wholePrize += (Rank.THIRD_PRIZE.prize * lottoResult[2])
        wholePrize += (Rank.FOURTH_PRIZE.prize * lottoResult[3])
        wholePrize += (Rank.FIFTH_PRIZE.prize * lottoResult[4])

        val rates: Double = wholePrize / user.amount.toDouble() * 100.0
        return rates
    }

    fun startLottoProgram() {

        setUser()
        printUserLotto()
        inputWinningNumber()
        checkResult()
        printResult()
    }

    fun setUser() {
        printHowMuchLotto()
        val amount = inputAmount()
        val lottoTickets = makeUserLottoTickets(amount)
        initializeUser(amount, lottoTickets)
    }

    fun printUserLotto() {
        printer.printTicketsCount(user.amount)
        printer.printMyTickets(user)
    }

    fun inputWinningNumber() {
        printer.printAskingWinningNumber()

        inputWinningNum()
        printer.printAskingBonusNumber()

        inputBonusNum()
    }

    fun printResult() {
        printer.printResultStats(lottoResult)
        val rates = calculatePrize()
        printer.printRatesofResult(rates)
    }

}