package racingcar.view

import racingcar.util.Form
import racingcar.util.Message

class OutputView {

    fun startResult() {
        println(Message.RESULT_START)
    }

    fun carProgressResult(name: String, progress: Int) {
        println(Message.ROUND_RESULT.format(name, Form.PROGRESS_ICON.repeat(progress)))
    }

    fun finalResult(winners: String) {
        println(Message.FINAL_WINNERS.format(winners))
    }

}