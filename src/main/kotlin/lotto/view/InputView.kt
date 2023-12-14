package lotto.view

import lotto.util.Message
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchasePrice(): String {
        println(Message.REQUEST_PURCHASE_PRICE)
        return Console.readLine()
    }

    fun inputWinningNumber(): String {
        println(Message.REQUEST_WINNING_NUM)
        return Console.readLine()
    }

    fun inputBonusNumber(): String {
        println(Message.REQUEST_BONUS_NUM)
        return Console.readLine()
    }

}