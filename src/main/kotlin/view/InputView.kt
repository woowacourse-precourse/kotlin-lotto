package view

class InputView {

    private val TICKET_PRICES = 1000
    private val MESSAGE_HOW_MUCH_BUY_TICKET = "구입금액을 입력해 주세요."
    private val ERROR_MESSAGE_BUY_TICKET = "[ERROR] 로또 구입 금액은 천원 단위 숫자로만 입력해야 합니다."
    private val REGULAR_CORRECT_MONEY = "^[0-9]+0{3,}$"

    private val MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private val ERROR_MESSAGE_WINNING_NUMBER = "[ERROR] 당첨 번호 규칙에 맞지 않습니다."

    // 구입할 금액 입력
    fun inputMoney(): Long {
        println(MESSAGE_HOW_MUCH_BUY_TICKET)
        // todo cosole readLine 체인지
        val money = readLine()
        try{
            if (money!!.matches(REGULAR_CORRECT_MONEY.toRegex()))
                return money.toLong()/TICKET_PRICES
        }catch (e: Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
        }
        throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
    }

    // 당첨 번호 입력
    fun inputWinningNumber(): List<Int>{
        println("\n$MESSAGE_WINNING_NUMBER")
        // todo cosole readLine 체인지
        val winningNumber = readLine()!!
        try {
            val sixWinningNumber =  winningNumber.split(",").map { it.toInt() }
            // 중복 체크 & 길이 체크
            if (sixWinningNumber.toSet().size != 6)
                throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
            // 1 ~ 45 사이 값인지 체크
            for (winningNumberIdx in sixWinningNumber){
                if (winningNumberIdx !in 1..45)
                    throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
            }
            return sixWinningNumber
        }catch (e:Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
        }

        throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
    }

}