package lotto

import camp.nextstep.edu.missionutils.Console

class methodCollection {

    fun howMuchDoYouHave(): Int {
        val usermoney = Console.readLine()
        var money = ""
        if (usermoney == "") {
            throw IllegalArgumentException(error.inputSomething.message)
        }
        for (cash in 0 until usermoney.length) {
            if (usermoney[cash].isDigit()) {
                money += usermoney[cash]
            }
            else if (!usermoney[cash].isDigit()) {
                throw IllegalArgumentException(error.onlyNumberInput.message)
            }
        }
        return money.toInt()
    }

    fun howManyBuy(money: Int): Int {
        val answer = money / 1000
        return answer
    }

    fun enterWinningNumber(): List<Int> {
        val userCheck = Console.readLine()
        val winningNumber = mutableListOf<Int>()
        val number = userCheck.split(',')
        if (!userCheck.contains(',')) {
            throw IllegalArgumentException(error.wrongInput.message)
        }
        for (num in 0 until number.size) {
            // 번호가 중복된 경우 에러 유발해야함
            if (winningNumber.contains(number[num].toInt())) {
                throw IllegalArgumentException(error.sameNumberInLotto.message)
            }
            winningNumber.add(number[num].toInt())
        }
        return winningNumber
    }

    fun enterBonusNumber(winningNumbers: List<Int>): Int {
        val userCheck = Console.readLine()
        if (!"^[0-9]*$".toRegex().matches(userCheck)) {
            throw IllegalArgumentException(error.wrongInput.message)
        }
        // 보너스 번호가 로또 번호와 같은 경우
        if (winningNumbers.contains(userCheck.toInt())) {
            throw IllegalArgumentException(error.sameNumberInBonus.message)
        }
        // 번호 입력을 1~45사이 안한 경우
        else if (userCheck.toInt() > 45 || userCheck.toInt() < 1) {
            throw IllegalArgumentException(error.wrongNumber.message)
        }
        return userCheck.toInt()
    }

    fun showLottoPaper(cnt: Int): MutableList<List<Int>> {
        var lottoCollection = mutableListOf<List<Int>>()
        var obj = LottoGames(numbers = listOf(0, 0, 0, 0, 0, 0))
        for (paper in 0 until cnt) {
            lottoCollection.add(obj.pickLottoNumbers())
        }
        return lottoCollection
    }

    fun showWinLottoPaper(lotto: List<Int>, sameNumber: Int, bonusNumber: Int): String {
        var winLottoPaper = ""
        if (sameNumber == 5) {
            if (lotto.contains(bonusNumber)) {
                winLottoPaper = "5+1"
                return winLottoPaper
            } else if (!lotto.contains(bonusNumber)) {
                winLottoPaper = "5"
                return winLottoPaper
            }
        }
        winLottoPaper = sameNumber.toString()
        return winLottoPaper
    }

    fun prizeRate(winLottoCollection: List<String>): Map<String, Int> {
        var prizeRate = mutableMapOf("3" to 0, "4" to 0, "5" to 0, "5+1" to 0, "6" to 0)
        if (winLottoCollection.contains("3")) {
            prizeRate += "3" to winLottoCollection.count { it == "3" }
        }
        if (winLottoCollection.contains("4")) {
            prizeRate += "4" to winLottoCollection.count { it == "4" }
        }
        if (winLottoCollection.contains("5")) {
            prizeRate += "5" to winLottoCollection.count { it == "5" }
        }
        if (winLottoCollection.contains("5+1")) {
            prizeRate += "5+1" to winLottoCollection.count { it == "5+1" }
        }
        if (winLottoCollection.contains("6")) {
            prizeRate += "6" to winLottoCollection.count { it == "6" }
        }
        return prizeRate
    }

    fun calculateProfitRate(price: Int, prizeRating: Map<String, Int>): Double {
        var profitRate = 0.0
        var totalreward = 0.0
        var reward = listOf(5000, 50000, 1500000, 30000000, 2000000000)
        totalreward += prizeRating.getValue("3") * reward[0]
        totalreward += prizeRating.getValue("4") * reward[1]
        totalreward += prizeRating.getValue("5") * reward[2]
        totalreward += prizeRating.getValue("5+1") * reward[3]
        totalreward += prizeRating.getValue("6") * reward[4]
        profitRate = String.format("%.2f", (totalreward / price) * 100).toDouble() // 둘째자리에서 반올림
        return profitRate
    }


}