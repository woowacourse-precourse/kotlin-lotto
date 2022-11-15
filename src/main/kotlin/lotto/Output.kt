package lotto

class Output {
    companion object {
        fun printNumbers(lottoNumber: MutableList<MutableList<Int>>, lottoCount: Int){
            print(lottoCount)
            getMessage(Message.COUNT)
            for(count in 0 until lottoCount){
                println(lottoNumber[count])
            }
        }
    }

}