package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Message


class InputView {

    fun requireDate(): String {
        println(Message.INPUT_DATE)
        return Console.readLine()
    }

    fun requireMenu(): String {
        println(Message.INPUT_MENU)
        return Console.readLine()
    }

}