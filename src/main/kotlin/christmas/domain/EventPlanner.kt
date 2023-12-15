package christmas.domain

import christmas.domain.model.BenefitInfo
import christmas.domain.model.EventDayOfWeek
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType
import christmas.utils.Rule

class EventPlanner(
    private val eventCalendar: EventCalendar,
    private val kiosk: Kiosk,
    private val eventBenefit: MutableMap<BenefitInfo, Int> = mutableMapOf()
) {

    fun computeDDay(date: Int) {
        if (eventCalendar.checkDDay(date))
            eventBenefit[BenefitInfo.D_DAY_DISCOUNT] =
                Rule.CHRISTMAS_START_DISCOUNT + (date - 1) * Rule.CHRISTMAS_DAY_DISCOUNT
    }

    fun computeBasicDay(date: Int) {
        return when (eventCalendar.checkDayOfWeek(date)) {
            EventDayOfWeek.WEEKEND ->
                eventBenefit[BenefitInfo.WEEKEND_DISCOUNT] = computeWeekend() * Rule.WEEKEND_DISCOUNT

            EventDayOfWeek.WEEKDAY ->
                eventBenefit[BenefitInfo.WEEKDAY_DISCOUNT] = computeWeekDay() * Rule.WEEKDAY_DISCOUNT
        }
    }

    fun computeStarDay(date: Int){
        if (eventCalendar.checkStartDay(date))
            eventBenefit[BenefitInfo.SPECIAL_DISCOUNT] = Rule.STAR_DISCOUNT
    }

    fun computeTotalPrice() {
        if (kiosk.getTotalOrderPrice() >= Rule.MIN_GIVEAWAY_PRICE)
            eventBenefit[BenefitInfo.GIVEAWAY_EVENT] = MenuInfo.getCurrentGiveawayPrice()
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
