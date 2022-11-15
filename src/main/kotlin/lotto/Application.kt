package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Computer.NumberCreate
import lotto.Computer.lottoList
import lotto.View.MessageOutput
import lotto.User.UserInput
import lotto.User.answer
import lotto.User.bonus
import lotto.User.ticket


fun main() {
    MessageOutput().printStartMessage()
    UserInput().buyPrice()

    NumberCreate(ticket)
    MessageOutput().printBuyMessage(ticket, lottoList)

    MessageOutput().printAnswerInputMessage()
    UserInput().answerNumbers()
    UserInput().bonusNumber()





}
