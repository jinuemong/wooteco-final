package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.utils.Message
import menu.domain.utils.Rule

class InputView {

    fun requireNames(): List<String> {
        println(Message.INPUT_NAMES)
        return Console.readLine().split(Rule.SPLIT_SEPARATOR)
    }

    fun requireCoachForbiddenMenu(): List<String> {
        println(Message.INPUT_FORBIDDEN_FOOD)
        return Console.readLine().split(Rule.SPLIT_SEPARATOR)
    }


}