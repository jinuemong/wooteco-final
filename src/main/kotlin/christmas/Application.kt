package christmas

import christmas.controller.EventController
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val eventController = EventController(
        inputView = InputView(),
        outputView = OutputView()
    )
    eventController.userFlow()
}
