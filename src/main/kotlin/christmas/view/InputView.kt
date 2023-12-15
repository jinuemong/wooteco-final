package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Form
import christmas.utils.Message


class InputView {

    fun requireDate(): String {
        println(Message.INPUT_DATE)
        return Console.readLine()
    }

    fun requireMenu(): List<String> {
        println(Message.INPUT_MENU)
        return separateUserInput(Console.readLine())
    }
    private fun separateUserInput(userInput: String): List<String> =
        userInput.split(Form.ORDER_SEPARATOR, Form.MENU_SEPARATOR)
}