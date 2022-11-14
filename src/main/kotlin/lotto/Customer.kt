package lotto

class Customer (private val spendMoney: Int){

    private var reward = 0
    private var earningRatio  = 0.0f
    private var selectedLottoList = listOf(listOf(0))

    fun getCustomerMoney():Int{
        return this.spendMoney
    }

    fun setReward(value : Int){
        this.reward = value
    }

    fun setEarningRatio(value: Float){
        this.earningRatio = value
    }

    fun setSelectedLottoList(value: List<List<Int>>){
        this.selectedLottoList = value
    }
}