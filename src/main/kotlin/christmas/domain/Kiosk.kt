package christmas.domain

import christmas.domain.model.Menu
import christmas.domain.model.MenuType

class Kiosk(
    private val menus: MutableMap<Menu, Int> = mutableMapOf()
) {


    fun orderMenu(menu: Menu,count : Int) {
        menus[menu] = (menus[menu] ?: 0) + count
    }

    fun getTotalOrderPrice(): Int {
        return menus.map { (menu, count) ->
            menu.getMenuPrice() * count
        }.sum()
    }

    fun getOrderMenuTypeCount(menuType: MenuType): Int {
        return menus.keys.count {
            it.getMenuType() == menuType
        }
    }

}