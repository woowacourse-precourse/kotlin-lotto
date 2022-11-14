package lotto.constants

enum class LottoWinCaseString(val caseNum:Int,val msg:String) {
    FIRST_WIN_MSG(4,"6개 일치 (2,000,000,000원) - "),
    SECOND_WIN_MSG(3,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_WIN_MSG(2,  "5개 일치 (1,500,000원) - "),
    FOURTH_WIN_MSG(1, "4개 일치 (50,000원) - "),
    FIFTH_WIN_MSG(0,"3개 일치 (5,000원) - ");

    companion object{
        fun getMsg(caseNum:Int):String{

            for(case in LottoWinCaseString.values()){
                if(case.caseNum==caseNum){
                    return case.msg
                }
            }

            return ""
        }
    }

}