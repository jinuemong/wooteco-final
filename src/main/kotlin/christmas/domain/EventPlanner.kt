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
        return if (eventCalendar.checkDDay(date)) {
            Rule.CHRISTMAS_START_DISCOUNT + (date-1) * Rule.CHRISTMAS_DAY_DISCOUNT
        } else {
            0
        }
    }

    fun computeBasicDay(date: Int): Int {
        return when(eventCalendar.checkDayOfWeek(date)){
            EventDayOfWeek.WEEKEND -> computeWeekend()
            EventDayOfWeek.WEEKDAY -> computeWeekDay()
        }
    }

    private fun computeWeekend(): Int{
        return 0 // rngus
    }

    private fun computeWeekDay(): Int{
        return 0 // rngus
    }

    companion object {
        private val CURRENT_WEEKEND_MENU = MenuType.MAIN
        private val CURRENT_WEEKDAY_MENU = MenuType.DESSERT
    }
}
