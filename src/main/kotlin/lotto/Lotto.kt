package lotto
import kotlin.collections.mutableListOf


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
fun getComputerInput(): MutableList <Int> {
    var com_number = mutableListOf<Int>()
    while(com_number.size < 6){
        val num = (1..45).random()
        if(!com_number.contains(num)) com_number.add(num)
    }
    return com_number.sorted().toMutableList()
}
