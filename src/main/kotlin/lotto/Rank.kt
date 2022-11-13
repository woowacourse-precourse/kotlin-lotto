package lotto
import utils.Messages.FIFTH_RANK_MESSAGE
import utils.Messages.FIRST_RANK_MESSAGE
import utils.Messages.FOURTH_RANK_MESSAGE
import utils.Messages.SECOND_RANK_MESSAGE
import utils.Messages.STATICS_COUNT_MESSAGE
import utils.Messages.THIRD_RANK_MESSAGE

class Ranking {
    enum class Rank {
        FIFTH {
            override fun print(winList: MutableList<Int>) {
                println(FIFTH_RANK_MESSAGE+winList[0]+ STATICS_COUNT_MESSAGE)
            }
        },
        FOURTH {
            override fun print(winList: MutableList<Int>) {
                println(FOURTH_RANK_MESSAGE+winList[1]+ STATICS_COUNT_MESSAGE)
            }
        },
        THIRD {
            override fun print(winList: MutableList<Int>) {
                println(THIRD_RANK_MESSAGE+winList[2]+ STATICS_COUNT_MESSAGE)
            }
        },
        SECOND {
            override fun print(winList: MutableList<Int>) {
                println(SECOND_RANK_MESSAGE+winList[3]+ STATICS_COUNT_MESSAGE)
            }
        },
        FIRST {
            override fun print(winList: MutableList<Int>) {
                println(FIRST_RANK_MESSAGE+winList[4]+ STATICS_COUNT_MESSAGE)
            }
        };
        open fun print(winList: MutableList<Int>) {
            println("")
        }
    }
}
