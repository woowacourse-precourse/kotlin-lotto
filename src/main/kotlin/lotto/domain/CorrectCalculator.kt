package lotto.domain

class CorrectCalculator {

    fun correctLottoNumber(winningLotto: Lotto, myLotto: Lotto): Int {
        val winningNumbers = winningLotto.getNumbers()
        val myNumbers = myLotto.getNumbers()
        var count = 0
        for (num in myNumbers) {
            if (winningNumbers.contains(num)) {
                count += 1
            }
        }
        return count
    }

    fun correctBonusNumber(myLotto: Lotto, bonusNumber: Int): Boolean {
        return myLotto.getNumbers().contains(bonusNumber)
    }
}
