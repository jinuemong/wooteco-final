package christmas.domain

import christmas.domain.model.EventDayOfWeek
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType
import christmas.utils.Rule

class EventPlanner(
    private val eventCalendar: EventCalendar,
    private val kiosk: Kiosk
) {

    fun computeDDay(date: Int): Int {
        return if (eventCalendar.checkDDay(date))
            Rule.CHRISTMAS_START_DISCOUNT + (date - 1) * Rule.CHRISTMAS_DAY_DISCOUNT
        else 0
    }

    fun computeBasicDay(date: Int): Int {
        return when (eventCalendar.checkDayOfWeek(date)) {
            EventDayOfWeek.WEEKEND -> computeWeekend() * Rule.WEEKEND_DISCOUNT
            EventDayOfWeek.WEEKDAY -> computeWeekDay() * Rule.WEEKDAY_DISCOUNT
        }
    }

    fun computeStarDay(date: Int): Int {
        return if (eventCalendar.checkStartDay(date)) Rule.STAR_DISCOUNT
        else 0
    }

    fun computeTotalPrice(): Int {
        return if (kiosk.getTotalOrderPrice() >= Rule.MIN_GIVEAWAY_PRICE)
            MenuInfo.getCurrentGiveawayPrice()
        else
            0
    }

    private fun computeWeekend(): Int {
        return kiosk.getOrderMenuTypeCount(CURRENT_WEEKEND_MENU)
    }

    private fun computeWeekDay(): Int {
        return kiosk.getOrderMenuTypeCount(CURRENT_WEEKDAY_MENU)
    }

    companion object {
        private val CURRENT_WEEKEND_MENU = MenuType.MAIN
        private val CURRENT_WEEKDAY_MENU = MenuType.DESSERT
    }
}
