package lotto.util

class ConsoleMessage {
    companion object {
        fun machine() = println("구입 금액을 입력해 주세요.")

        fun purchase(count: Int) = println("\n${count}개를 구매했습니다.")

        fun winning() = println("\n당첨 번호를 입력해 주세요.")

        fun bonus() = println("\n보너스 번호를 입력해 주세요.")

        fun lottoNumber(numbers: List<Int>) = println(numbers)
    }
}