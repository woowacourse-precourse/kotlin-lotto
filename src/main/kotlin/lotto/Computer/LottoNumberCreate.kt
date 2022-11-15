package lotto.Computer

import camp.nextstep.edu.missionutils.Randoms

fun NumberCreate (){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    print(numbers)
}



