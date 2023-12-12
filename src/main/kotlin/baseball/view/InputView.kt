package baseball.view

import baseball.util.Message
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun enterNumber(): String {
        print(Message.GAME_NUM_INPUT)
        return Console.readLine()
    }

    fun enterGameRestart(): String {
        println(Message.GAME_RESTART)
        return Console.readLine()
    }

}