package lotto.util

val br = System.`in`.bufferedReader()

fun readSpendMoney(): Int {
    return try {
        val spendMoney = br.readLine().toInt()
        if (spendMoney % 1000 != 0) {
            printErrorMessage(ErrorType.CANNOT_DIVISIBLE_INPUT)
            throw IllegalArgumentException()
        }
        spendMoney
    } catch (e: java.lang.Exception) {
        printErrorMessage(ErrorType.WRONG_TYPE_INPUT)
        throw IllegalArgumentException()
    }
}

fun bufferedReaderClose() {
    br.close()
}