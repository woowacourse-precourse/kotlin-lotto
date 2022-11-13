package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val LOTTO_PRICE = 1000
const val RANK_5TH_REWARD = 5000
const val RANK_4TH_REWARD = 50000
const val RANK_3RD_REWARD = 1500000
const val RANK_2ND_REWARD = 30000000
const val RANK_1ST_REWARD = 2000000000

class LottoGame {

    private var money = ""
    private val lottos = mutableListOf<List<Int>>()
    private val checkprize: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0)
    private var bonusnumber = 0

    fun gamestart() {
        getusermoney()
        makelottonumber()
        val userlotto = getuserlotto()
        checklotto(userlotto)
        printresult()
    }

    private fun getusermoney() {
        Lotto.messagetogivemoney()
        money = Console.readLine()
    }

    private fun makelottonumber() {
        LottoErrorCheck.checkallmoneyerror(money)
        val count = money.toInt() / LOTTO_PRICE
        Lotto.printcount(count)
        createlottos(count)
        Lotto.printlottolist(lottos.toList())
    }

    private fun createlottos(count: Int) {
        for (number: Int in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(numbers)
        }
    }
    private fun getuserlotto(): List<Int> {
        Lotto.messagetogiveuserlotto()
        val userinput = Console.readLine()
        val userinputparsing = userinput.split(",")
        val userinputnumber = mutableListOf<Int>()

        for (element in userinputparsing) {
            LottoErrorCheck.checkinputisnumber(element)
            userinputnumber.add(element.toInt())
        }

        return userinputnumber.toList()

    }


    private fun getbonusnumber(userlotto: List<Int>) {
        Lotto.messagetogiveuserbonus()
        val tempbonus = Console.readLine()
        LottoErrorCheck.checkinputisnumber(tempbonus)
        LottoErrorCheck.checknumberisinlottorange(tempbonus.toInt())
        LottoErrorCheck.bonusballcheck(userlotto, tempbonus.toInt())
        bonusnumber = tempbonus.toInt()
    }

    private fun checklotto(userlotto: List<Int>) {
        Lotto(userlotto)
        getbonusnumber(userlotto)
        for (number: Int in 0 until lottos.size) {
            val rank = Lotto.lottocheck(userlotto, lottos[number])
            val itdonothitfivenumber = prizecheck(rank)
            if (!itdonothitfivenumber && lottos[number].contains(bonusnumber))
                checkprize[3] += 1
            else if (!itdonothitfivenumber)
                checkprize[2] += 1

        }
    }

    private fun prizecheck(rank: Int): Boolean {
        if (rank == 3)
            checkprize[0] += 1
        if (rank == 4)
            checkprize[1] += 1
        if (rank == 5)
            return false
        if (rank == 6)
            checkprize[4] += 1

        return true
    }

    private fun printresult() {
        Lotto.printprize(checkprize.toList())
        val lottoyield: Double = ((RANK_5TH_REWARD * checkprize[0] + RANK_4TH_REWARD * checkprize[1]
                + RANK_3RD_REWARD * checkprize[2] + RANK_2ND_REWARD * checkprize[3]
                + RANK_1ST_REWARD * checkprize[4]) / money.toDouble()) * 100
        Lotto.printyield(lottoyield)
    }

}