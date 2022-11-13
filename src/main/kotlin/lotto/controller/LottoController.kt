package lotto.controller

import lotto.domain.ComputerNumber
import lotto.domain.InputValidation
import lotto.domain.Judgement
import lotto.domain.Lotto
import lotto.view.ConsoleMessage
import lotto.view.UserNumber
import java.text.DecimalFormat
import java.util.stream.Collectors

class LottoController {

    private lateinit var userWinningNumber: Lotto
    private val userNumber = UserNumber()
    private val message = ConsoleMessage()
    private var purchaseAmount: Int = 0
    private var computerNumber: List<Lotto> = listOf()
    private var userBonusNumber: Int = 0

    fun playLotto() {
        try {
            startLotto()
            makeComputerLotto()
            inputValidationCheck()
            bonusValidationCheck()
            judgeNumber()
        } catch (e: IllegalArgumentException) {
            message.printError(e.message.toString())
        }
    }

    private fun startLotto() {
        message.inputPurchaseAmount()
        val purchase = userNumber.inputNumber()
        if (numberValidation(purchase)) {
            message.verifyNumber(purchaseAmount)
        }
    }

    private fun makeComputerLotto() {
        computerNumber = ComputerNumber(purchaseAmount).makeComputerBaseball()
        message.outputComputerNumber(computerNumber)
    }

    private fun inputValidationCheck() {
        message.inputWinningNumber()
        val inputUserNumber = userNumber.inputNumber()
        if (winningNumberValidation(inputUserNumber)) {
            userWinningNumber = Lotto(
                inputUserNumber.split(',')
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            )
        }
    }

    private fun bonusValidationCheck() {
        message.inputBonusNumber()
        val inputBonusNumber = userNumber.inputNumber()
        if (bonusNumberValidation(inputBonusNumber)) {
            userBonusNumber = inputBonusNumber.toInt()
        }
    }

    private fun judgeNumber() {
        val compareUserAndComputer = Judgement(computerNumber, userWinningNumber, userBonusNumber)
        val decimal = DecimalFormat("#,##0.0%")
        message.winningResult(compareUserAndComputer.calculate())
        message.winningTotalRevenue(decimal.format(compareUserAndComputer.statistics()))
    }

    private fun numberValidation(amount: String): Boolean {
        if (InputValidation(amount).inputNumberExceptionCheck()) {
            calculateNumber(amount.toInt())
            return true
        }
        return false
    }

    private fun calculateNumber(amount: Int) {
        purchaseAmount = amount / Lotto.Information.PRICE.number
    }

    private fun winningNumberValidation(numberLine: String): Boolean {
        if (InputValidation(numberLine).winningNumberExceptionCheck()) {
            return true
        }
        return false
    }

    private fun bonusNumberValidation(numberLine: String): Boolean {
        return InputValidation(numberLine).bonusNumberExceptionCheck(userWinningNumber)
    }
}