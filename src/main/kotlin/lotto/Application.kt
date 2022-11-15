package lotto

import lotto.controller.LottoController


fun main() {
        try {
                LottoController().GameStart()

        }catch (e:IllegalArgumentException){ }
}


