package lotto

class WinningCount{
    fun WinningNumbers(total_numbers:MutableList<List<Int>>,lotto_numbers_list:MutableList<Int>,bonus:Int): MutableMap<Int, Int> {
        val winning_numbers_count= mutableMapOf<Int,Int>(5000 to 0, 50000 to 0, 1500000 to 0, 30000000 to 0, 2000000000 to 0)

        for(elem in total_numbers){
            val winning_numbers=lotto_numbers_list.toSet().intersect(elem)

        }
        return winning_numbers_count
    }
}