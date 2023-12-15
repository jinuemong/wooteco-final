package christmas

import christmas.controller.EventController
import christmas.domain.EventCalendar
import christmas.validation.UserValidation
import christmas.view.InputView
import christmas.view.OutputView

fun main() {

    try {
        val eventController = EventController(
            inputView = InputView(),
            outputView = OutputView(),
            eventCalendar = EventCalendar(),
            userValidation = UserValidation()
        )
        eventController.userFlow()

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
