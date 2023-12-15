package christmas.controller

import christmas.domain.EventCalendar
import christmas.domain.EventPlanner
import christmas.domain.Kiosk
import christmas.domain.model.MenuInfo
import christmas.utils.Form
import christmas.utils.Rule
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
            try {
                val userInput = inputView.requireMenu()
                val names = getNames(userInput)
                val numbers = getNumbers(userInput)
                userValidation.checkMenus(names,numbers)
                initKiosk()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        menuOrder(menus)
        outputView.computeStart()
        outputView.orderMenu(menus.keys.toList())
    }

    private fun compute() {
        if (kiosk.getTotalOrderPrice() > Rule.MIN_ORDER_PRICE) {
            eventPlanner.computeDDay()
            eventPlanner.computeBasicDay(kiosk)
            eventPlanner.computeStarDay()
            eventPlanner.computeGiveaway(kiosk.getTotalOrderPrice())
        }
    }

    private fun result() {
        outputView.orderPrice(kiosk.getTotalOrderPrice())
        outputView.giveawayMenu(eventPlanner.checkGiveaway())
        outputView.totalBenefit(eventPlanner.benefits())
        outputView.totalBenefitPrice(eventPlanner.computeTotalBenefit())
        outputView.discountPrice(eventPlanner.computeDiscountPrice(kiosk.getTotalOrderPrice()))
        outputView.eventBadge(eventPlanner.computeGiveBadge())
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

    private fun getNames(pieces: List<String>): List<String> =
        pieces.filterIndexed { index, _ -> checkIndexIsEven(index) }

    private fun getNumbers(pieces: List<String>): List<String> =
        pieces.filterIndexed { index, _ -> !checkIndexIsEven(index) }

    private fun checkIndexIsEven(index: Int): Boolean = index % 2 == 0

}