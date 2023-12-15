package christmas.view

import christmas.domain.model.Badge
import christmas.domain.model.BenefitInfo
import christmas.domain.model.MenuInfo
import christmas.utils.Form
import christmas.utils.Message
import christmas.utils.Rule
import java.text.DecimalFormat

class OutputView {

    fun orderStart() {
        println(Message.ORDER_START)
    }

    fun computeStart() {
        println(Message.ORDER_END)
        println()
    }

    fun orderMenu(menus: List<String>) {
        println(Message.ORDER_MENU)
        menus.forEach { menu ->
            println(menu)
        }
    }

    fun orderPrice(price: Int){
        println()
        println(Message.ORDER_PRICE)
        println(makePriceForm(price))
    }

    fun giveawayMenu(){
        println()
        println(Message.GIVEAWAY_MENU)
        println(MenuInfo.getCurrentGiveawayInfo())
    }

    fun totalBenefit(benefits: Map<BenefitInfo,Int>){
        println()
        println(Message.BENEFIT)
        benefits.forEach { (benefit,price) ->
            println(benefit.benefitMessaging()+makePriceForm(price))
        }
    }

    fun totalBenefitPrice(price: Int){
        println()
        println(Message.TOTAL_DISCOUNT_PRICE)
        println(makePriceForm(price))
    }

    fun discountPrice(price: Int){
        println()
        println(Message.DISCOUNTED_PRICE)
        println(makePriceForm(price))
    }

    fun eventBadge(badge: Badge){
        println()
        println(Message.EVENT_BADGE)
        println(badge.getBadgeName())
    }


    private fun makePriceForm(price: Int): String{
        return DecimalFormat(Form.RETURN_FORMAT).format(price)+Form.UNIT_PRICE
    }


}