package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.utils.Message

class InputView {

    fun requireNames(): String {
        println(Message.INPUT_NAMES)
        return Console.readLine()
    }

    fun requireCoachForbiddenMenu(): String {
        println(Message.INPUT_FORBIDDEN_FOOD)
        return Console.readLine()
    }

}