package lotto

class InputNumbers {
    companion object {
        fun inputPrice(): Int {
            getMessage(Message.PRICE)
            return readLine()!!.toInt()
        }

        fun inputWinning(): String {
            getMessage(Message.NUMBER)
            val winning = readLine()
            return winning.toString()
        }

        fun inputBonus(): Int {
            getMessage(Message.BONUS)
            val bonusNumber = readLine()
            return bonusNumber!!.toInt()
        }
    }

}