package lotto.util

val br = System.`in`.bufferedReader()

fun readSpendMoney(): Int{
    return try{
        br.readLine().toInt()
    }catch (e: java.lang.Exception){
        printErrorMessage(ErrorType.WRONG_TYPE_INPUT)
        throw IllegalArgumentException()
    }
}

fun bufferedReaderClose(){
    br.close()
}