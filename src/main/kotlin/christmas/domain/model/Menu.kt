package christmas.domain.model

import christmas.domain.model.appetizer.Appetizer

open class Menu(
    private val menuType: MenuType,
    private val menuInfo: MenuInfo
) {

    fun getMenuPrice(): Int = menuInfo.getOrderPrice()
    fun getMenuType(): MenuType = menuType

}