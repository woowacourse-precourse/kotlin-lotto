package lotto

import lotto.Computer.NumberCreate
import lotto.Computer.earnCalculate
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
    println(answer)

    MessageOutput().printBonusInputMessage()
    UserInput().bonusNumber()
    println(bonus)

    Lotto(answer).calculateWon()
    earnCalculate()

    MessageOutput().printAverageInputMessage()
    MessageOutput().printMatchedNumberMessage()
}
