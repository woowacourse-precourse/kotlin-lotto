package lotto.Computer

import lotto.*
import lotto.User.ticket

public var earning : Double = 0.0

fun earnCalculate(){
    val outlay = (ticket * 1000).toDouble()
    val income = (matchedThree * 5000 + matchedFour * 50000 + matchedFive * 1500000 + matchedBonus * 30000000 + matchedSix * 2000000000).toDouble()

    earning = (( income / outlay ) * 100)
}