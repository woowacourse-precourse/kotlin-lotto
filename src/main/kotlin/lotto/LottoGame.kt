package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val LOTTO_PRICE = 1000

class LottoGame {

    private var money = ""
    private val lottos = mutableListOf<List<Int>>()
    private val checkprize:MutableList<Int> = mutableListOf(0,0,0,0,0)
    private var bonusnumber =0

    fun gamestart() {
        getusermoney()
        makelottonumber()
        val userlotto=getuserlotto()
        getbonusnumber()
        checklotto(userlotto)

    }


    private fun messagetogivemoney(){
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

    private fun messagetogiveuserlotto(){
        println("당첨 번호를 입력해 주세요.")
    }

    private fun getuserlotto():List<Int>{
        messagetogiveuserlotto()
        val userinput = Console.readLine()
        val userinputparsing= userinput.split(",")
        val userinputnumber= mutableListOf<Int>()

        for(element in userinputparsing){
            LottoErrorCheck.checkinputisnumber(element)
            userinputnumber.add(element.toInt())
        }

        return userinputnumber.toList()

    }

    private fun messagetogiveuserbonus(){
        println("보너스 번호를 입력해 주세요.")
    }
    private fun getbonusnumber(){
        messagetogiveuserbonus()
        val tempbonus = Console.readLine()
        LottoErrorCheck.checkinputisnumber(tempbonus)
        LottoErrorCheck.checknumberisinlottorange(tempbonus.toInt())
        bonusnumber=tempbonus.toInt()
    }

    private fun checklotto(userlotto:List<Int>){
        val checklotto = Lotto(userlotto)
        for(elements in lottos){
            val rank = checklotto.lottocheck(userlotto,elements)
            if(!prizecheck(rank)&&userlotto.contains(bonusnumber))
                checkprize[3]+=1
            else if(!prizecheck(rank))
                checkprize[2]+=1

        }
    }

    private fun prizecheck(rank:Int):Boolean{
        if(rank==3)
            checkprize[0]+=1
        if(rank==4)
            checkprize[1]+=1
        if(rank==5)
            return false
        if(rank==6)
            checkprize[4]+=1

        return true
    }
}