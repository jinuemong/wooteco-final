package christmas.domain

import christmas.domain.model.*
import christmas.utils.Rule

class EventPlanner(
    private val date: Int,
    private val eventCalendar: EventCalendar,
    private val eventBenefit: MutableMap<BenefitInfo, Int> = mutableMapOf()
) {

    fun computeDDay() {
        if (eventCalendar.checkDDay(date))
            eventBenefit[BenefitInfo.D_DAY_DISCOUNT] =
                Rule.CHRISTMAS_START_DISCOUNT + (date - 1) * Rule.CHRISTMAS_DAY_DISCOUNT
    }

    fun computeBasicDay(kiosk: Kiosk) {
        return when (eventCalendar.checkDayOfWeek(date)) {
            EventDayOfWeek.WEEKEND ->
                eventBenefit[BenefitInfo.WEEKEND_DISCOUNT] =
                    kiosk.getOrderMenuTypeCount(CURRENT_WEEKEND_MENU) * Rule.WEEKEND_DISCOUNT

            EventDayOfWeek.WEEKDAY ->
                eventBenefit[BenefitInfo.WEEKDAY_DISCOUNT] =
                    kiosk.getOrderMenuTypeCount(CURRENT_WEEKDAY_MENU) * Rule.WEEKDAY_DISCOUNT
        }
    }

    fun computeStarDay() {
        if (eventCalendar.checkStartDay(date))
            eventBenefit[BenefitInfo.SPECIAL_DISCOUNT] = Rule.STAR_DISCOUNT
    }

    fun computeGiveaway(totalPrice: Int) { //kiosk.getTotalOrderPrice()
        if ( totalPrice >= Rule.MIN_GIVEAWAY_PRICE)
            eventBenefit[BenefitInfo.GIVEAWAY_EVENT] = MenuInfo.getCurrentGiveawayPrice()
    }

    fun computeDiscountPrice(totalPrice: Int): Int { //kiosk.getTotalOrderPrice()
        return totalPrice - computeTotalBenefit()
    }

    fun computeGiveBadge(): Badge {
        return Badge.getPriceBadge(computeTotalBenefit())
    }

    fun computeTotalBenefit(): Int {
        return eventBenefit.values.sum()
    }

    companion object {
        private val CURRENT_WEEKEND_MENU = MenuType.MAIN
        private val CURRENT_WEEKDAY_MENU = MenuType.DESSERT
    }
}
