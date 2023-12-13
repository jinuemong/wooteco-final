package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Message

class InputView {

    fun inputCarNames(): String {
        println(Message.GAME_START)
        return Console.readLine()
    }

    fun inputNumber(): String {
        println(Message.TYPE_NUMBER)
        return Console.readLine()
    }

}