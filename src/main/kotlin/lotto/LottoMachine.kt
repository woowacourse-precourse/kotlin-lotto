package lotto

import camp.nextstep.edu.missionutils.Randoms

private const val LOTTO_SIZE = 6

class LottoMachine {
    private val printer: LottoPrinter
    private val console: LottoConsole
    private lateinit var user: User

    constructor(printer: LottoPrinter, console: LottoConsole) {
        this.printer = printer
        this.console = console

    }


    fun inputAmount(): Int = console.inputAmount()
    fun printHowMuchLotto() = printer.printIntroMsg()
    fun printMyLottoTickets(){
        printer.printTicketsCount(user.amount)
        printer.printMyTickets(user)
    }



    fun makeRandomNumber(): Lotto {
        val numbers = mutableListOf<Int>()
        while (numbers.size < LOTTO_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
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

    fun initializeUser(amount:Int,lottoTickets:List<Lotto>){
        this.user=User(amount,lottoTickets)
    }


    fun startLottoProgram() {
        printer.printIntroMsg()
        val amount = console.inputAmount()
        val lottoTickets = makeUserLottoTickets(amount)
        initializeUser(amount,lottoTickets)
        printer.printTicketsCount(amount)
        printer.printMyTickets(user)

    }

}