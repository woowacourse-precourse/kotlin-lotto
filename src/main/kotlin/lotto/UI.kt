package lotto

import camp.nextstep.edu.missionutils.Console

class UI {
    /**
     * Functions named get[]()
     *
     * @return [] in string from user input
     */
    fun getMoney(): String { //-1 : error
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
    fun getLotteryNumber(): List<String> {
        println("당첨 번호를 입력해 주세요.")

        val lotteryNumber = Console.readLine()
        return lotteryNumber.split(",")
    }
    fun getBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }
}