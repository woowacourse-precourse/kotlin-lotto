package lotto

import java.lang.IllegalArgumentException

const val ERROR_WIN_SIZE = "[ERROR] 당첨 로또 번호는 6개의 숫자로 구분지어 입력해야 합니다."
const val ERROR_WIN_RANGE = "[ERROR] 당첨 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val ERROR_WIN_DUPLICATE = "[ERROR] 당첨 로또 번호는 중복되면 안됩니다."
const val ERROR_BONUS = "보너스 번호는 1부터 45사이의 숫자여야 합니다."

enum class LottoWin(var number : Int) {
    NUM1(0),
    NUM2(0),
    NUM3(0),
    NUM4(0),
    NUM5(0),
    NUM6(0),
    BONUS(0);

    companion object{
        private val regex="[0-9]{1,2}".toRegex()

        fun input(){
            println("당첨 번호를 입력해 주세요.")
            val numbers = readLine()?:""
            inputNumbers(numbers)
            println("보너스 번호를 입력해 주세요.")
            val bonus= readLine()?:""
            inputBonus(bonus)
        }

        fun inputNumbers(numbers : String){
            val numbers = numbers.split(",")
            numbersException(numbers)
            NUM1.number=numbers[0].toInt()
            NUM2.number=numbers[1].toInt()
            NUM3.number=numbers[2].toInt()
            NUM4.number=numbers[3].toInt()
            NUM5.number=numbers[4].toInt()
            NUM6.number=numbers[5].toInt()
        }

        private fun numbersException(numbers :List<String>){
            require(numbers.size== 6&&numbers.all{it.matches(regex)}){
                println(ERROR_WIN_SIZE)
                throw IllegalArgumentException(ERROR_WIN_SIZE)
            }
            require(numbers.all{it.toInt() in MIN..MAX}){
                println(ERROR_WIN_RANGE)
                throw IllegalArgumentException(ERROR_WIN_RANGE)
            }
            require(notDuplicate(numbers)){
                println(ERROR_WIN_DUPLICATE)
                throw IllegalArgumentException(ERROR_WIN_DUPLICATE)
            }
        }

        fun inputBonus(bonus : String){
            bonusException(bonus)
            BONUS.number=bonus.toInt()
        }

        private fun bonusException(bonus : String){
            require(bonus.matches(regex)){
                println(ERROR_BONUS)
                throw IllegalArgumentException(ERROR_BONUS)
            }
            require(bonus.toInt() in MIN..MAX){
                println(ERROR_BONUS)
                throw IllegalArgumentException(ERROR_BONUS)
            }
        }

        private fun notDuplicate(numbers: List<String>): Boolean{
            return numbers.size == numbers.distinct().size
        }
    }
}