package baseball

import baseball.controller.GameController
import baseball.vaildation.CheckInputValidation
import baseball.view.InputView
import baseball.view.OutputView

fun main() {

//    try {
    val gameController = GameController(
        inputView = InputView(),
        outputView = OutputView(),
        verifier = CheckInputValidation()
    )
    gameController.userFlow()

//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//    }
}
