package christmas.controller

import christmas.domain.EventCalendar
import christmas.domain.EventPlanner
import christmas.domain.Kiosk
import christmas.domain.model.MenuInfo
import christmas.utils.Form
import christmas.utils.Message
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


        while (!::kiosk.isInitialized) {
            try {
                val userInput = inputView.requireMenu()
                val names = getNames(userInput)
                val numbers = getNumbers(userInput)
                userValidation.checkMenus(names,numbers)
                initKiosk(names,numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

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


    private fun initKiosk(names: List<String>, numbers: List<String>) {
        outputView.computeStart()
        println(Message.ORDER_MENU)
        kiosk = Kiosk()

        names.forEachIndexed { index, name ->
            val menu = MenuInfo.getMenu(MenuInfo.getMenuInfo(name))
            val count = numbers[index].toInt()
            kiosk.orderMenu(menu, count)
            outputView.orderMenu(name,count)
        }
    }

    private fun initEventPlanner(date: Int) {
        eventPlanner = EventPlanner(
            date = date,
            eventCalendar = eventCalendar
        )
    }

    private fun getNames(pieces: List<String>): List<String> =
        pieces.filterIndexed { index, _ -> checkIndexIsEven(index) }

    private fun getNumbers(pieces: List<String>): List<String> =
        pieces.filterIndexed { index, _ -> !checkIndexIsEven(index) }

    private fun checkIndexIsEven(index: Int): Boolean = index % 2 == 0

}