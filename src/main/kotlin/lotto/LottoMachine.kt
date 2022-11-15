package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    private var numberOfLotto: Int = 0
    private var bonusNumber = 0
    private lateinit var rankCount: MutableList<Int>
    private var prizeMoney = 0.0

    fun start() {
        val paymentInput = View.getPaymentAmount()
        numberOfLotto = getNumberOfLottos(paymentInput)

        val lottos: ArrayList<Lotto> = arrayListOf()
        repeat(numberOfLotto) {
            lottos.add(generateLotto())
        }

        View.printNumberOfLottos(numberOfLotto)
        View.printLottos(lottos)

        val winningNumberInput = View.getWinningNumber()
        val winningLotto = convertNumbersToLotto(winningNumberInput)

        bonusNumber = View.getBonusNumber().toInt()
        checkBonusNumberException(winningLotto, bonusNumber)

        calculateResult(lottos, winningLotto)
        val earningsRate = getEarningsRate()

        View.printResultStats(rankCount, earningsRate)
    }

    fun getNumberOfLottos(payment: String): Int {
        checkPaymentException(payment)
        return payment.toInt() / 1000
    }

    fun checkPaymentException(payment: String) {
        var price = -1
        try {
            price = payment.toInt()
        } catch (e: IllegalArgumentException){
            println("[ERROR] 숫자만 입력해 주세요.")
            throw NoSuchElementException("[ERROR] 숫자만 입력해 주세요.")
        }
        if (price % 1000 != 0) {
            println("[ERROR] 1000원으로 나눠지지 않습니다.")
            throw IllegalArgumentException("[ERROR] 1000원으로 나눠지지 않습니다.")
        }
    }

    fun generateLotto(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(randomNumbers)
    }

    fun convertNumbersToLotto(numbers: String): Lotto {
        return Lotto(numbers.split(",").map { it.toInt() }.toList().sorted())
    }

    fun checkBonusNumberException(winningLotto: Lotto, number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] 로또 번호 범위(1~45)를 벗어났습니다.")
        }
        if (winningLotto.getNumbers().contains(number)) {
            throw IllegalArgumentException("[ERROR] 당첨 번호와 중복됩니다.")
        }
    }

    fun calculateResult(lottos: List<Lotto>, winningLotto: Lotto) {
        rankCount = mutableListOf(0, 0, 0, 0, 0)
        prizeMoney = 0.0
        lottos.forEach { calculateLottoResult(it, winningLotto) }
    }

    fun calculateLottoResult(lotto: Lotto, winningLotto: Lotto) {
        val matchCount = lotto.getNumbers().count { winningLotto.getNumbers().contains(it) }
        when (matchCount) {
            6 -> {
                prizeMoney += 2000000000
                rankCount[0]++
            }
            5 -> {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    prizeMoney += 30000000
                    rankCount[1]++
                } else {
                    prizeMoney += 1500000
                    rankCount[2]++
                }
            }
            4 -> {
                prizeMoney += 50000
                rankCount[3]++
            }
            3 -> {
                prizeMoney += 5000
                rankCount[4]++
            }
        }
    }

    fun getEarningsRate(): String {
        return String.format("%.1f", (prizeMoney / (numberOfLotto * 1000.0)) * 100)
    }

}