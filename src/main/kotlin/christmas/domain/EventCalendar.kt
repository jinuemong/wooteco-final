package christmas.domain

import christmas.domain.model.EventDayOfWeek
import christmas.utils.Rule

class EventCalendar {

    fun checkDDay(date: Int): Boolean {
        return date in Rule.START_DATE..D_DAY
    }

    fun checkDayOfWeek(date: Int): EventDayOfWeek {
        return if (date % WEEKEND_CYCLE == FIRST_WEEKEND ||
            date % WEEKEND_CYCLE == SECOND_WEEKEND
        ) EventDayOfWeek.WEEKEND
        else EventDayOfWeek.WEEKDAY
    }

    fun checkStartDay(date: Int): Boolean {
        return date % STAR_CYCLE == START_STAR_DAY || date == D_DAY
    }

    companion object {

        private const val D_DAY = 25

        private const val START_STAR_DAY = 3
        private const val STAR_CYCLE = 7

        private const val FIRST_WEEKEND = 1
        private const val SECOND_WEEKEND = 2
        private const val WEEKEND_CYCLE = 7
    }

}