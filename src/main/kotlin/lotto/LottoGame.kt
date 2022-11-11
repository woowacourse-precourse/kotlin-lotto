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
        getbonusnumber()
        checklotto(userlotto)
        printresult()
    }


    private fun messagetogivemoney() {
        println("구입금액을 입력해 주세요.")
    }

    private fun getusermoney() {
        messagetogivemoney()
        money = Console.readLine()
    }

    private fun makelottonumber() {
        LottoErrorCheck.checkallmoneyerror(money)
        val count = money.toInt() / LOTTO_PRICE
        printcount(count)
        createlottos(count)
        printlottolist()
    }

    private fun printcount(count: Int) {
        println("$count" + "개를 구입했습니다.")
    }

    private fun createlottos(count: Int) {
        for (number: Int in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(numbers)
        }
    }

    private fun printlottolist() {
        for (number: Int in 0 until lottos.size) {
            println(lottos[number])
        }
    }

    private fun messagetogiveuserlotto() {
        println("당첨 번호를 입력해 주세요.")
    }

    private fun getuserlotto(): List<Int> {
        messagetogiveuserlotto()
        val userinput = Console.readLine()
        val userinputparsing = userinput.split(",")
        val userinputnumber = mutableListOf<Int>()

        for (element in userinputparsing) {
            LottoErrorCheck.checkinputisnumber(element)
            userinputnumber.add(element.toInt())
        }

        return userinputnumber.toList()

    }

    private fun messagetogiveuserbonus() {
        println("보너스 번호를 입력해 주세요.")
    }

    private fun getbonusnumber() {
        messagetogiveuserbonus()
        val tempbonus = Console.readLine()
        LottoErrorCheck.checkinputisnumber(tempbonus)
        LottoErrorCheck.checknumberisinlottorange(tempbonus.toInt())
        bonusnumber = tempbonus.toInt()
    }

    private fun checklotto(userlotto: List<Int>) {
        val checklotto = Lotto(userlotto)
        for (elements in lottos) {
            val rank = checklotto.lottocheck(userlotto, elements)
            if (!prizecheck(rank) && userlotto.contains(bonusnumber))
                checkprize[3] += 1
            else if (!prizecheck(rank))
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
        printprize()
        printyield()
    }

    private fun printprize(){
        println(
            "당첨 통계" +
                    "---" +
                    "3개 일치 (5,000원) - ${checkprize[0]}개" +
                    "4개 일치 (50,000원) - ${checkprize[1]}개" +
                    "5개 일치 (1,500,000원) - ${checkprize[2]}개" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${checkprize[3]}개" +
                    "6개 일치 (2,000,000,000원) - ${checkprize[4]}개"
        )
    }

    private fun printyield(){
        val lottoyield:Double = (RANK_5TH_REWARD * checkprize[0] + RANK_4TH_REWARD * checkprize[1]
                + RANK_3RD_REWARD * checkprize[2] + RANK_2ND_REWARD * checkprize[3]
                + RANK_1ST_REWARD * checkprize[4]) / money.toDouble()
        println("총 수익률은"+String.format("%.1f", lottoyield) +"입니다.")

    }

}