package christmas.controller

import christmas.domain.EventCalendar
import christmas.domain.EventPlanner
import christmas.domain.Kiosk
import christmas.domain.model.MenuInfo
import christmas.utils.Form
import christmas.view.InputView
import christmas.view.OutputView
import christmas.validation.UserValidation

class EventController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val eventCalendar: EventCalendar,
    private val userValidation: UserValidation
) {

    private lateinit var kiosk: Kiosk
    private lateinit var eventPlanner: EventPlanner

    fun userFlow() {
        userDate()
        order()
        compute()
        result()
    }

    private fun userDate() {
        outputView.orderStart()

        while (!::eventPlanner.isInitialized) {
            try {
                val userInput = inputView.requireDate()
                userValidation.checkUserDate(userInput)
                initEventPlanner(userInput.toInt())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    private fun order() {

        val menus: MutableMap<String, Int> = mutableMapOf()

        while (!::kiosk.isInitialized) {
            val userInput = inputView.requireMenu()
            userValidation.checkMenus(userInput)
            initKiosk()
        }

        menuOrder(menus)
        outputView.computeStart()
        outputView.orderMenu(menus.keys.toList())
    }

    private fun compute(){
        eventPlanner.computeDDay()
        eventPlanner.computeBasicDay(kiosk)
        eventPlanner.computeStarDay()
        eventPlanner.computeGiveaway(kiosk.getTotalOrderPrice())
    }

    private fun result(){
        outputView.orderPrice(kiosk.getTotalOrderPrice())
        outputView.giveawayMenu(eventPlanner.checkGiveaway())
    }


    private fun initKiosk() {
        kiosk = Kiosk()
    }

    private fun initEventPlanner(date: Int) {
        eventPlanner = EventPlanner(
            date = date,
            eventCalendar = eventCalendar
        )
    }

    private fun menuOrder(menus: Map<String, Int>) {
        menus.forEach { (name, count) ->
            val menu = MenuInfo.getMenu(MenuInfo.getMenuInfo(name))
            kiosk.orderMenu(menu, count)
        }
    }

}