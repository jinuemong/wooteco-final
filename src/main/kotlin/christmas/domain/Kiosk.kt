package christmas.domain

import christmas.domain.model.Menu
import christmas.domain.model.MenuType

class Kiosk {

    private val menus: MutableMap<Menu, Int> = mutableMapOf()

    fun orderMenu(menu: Menu) {
        menus[menu] = (menus[menu] ?: 0) + 1
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

    fun checkOrderCount(): Int {
        return menus.values.sum()
    }
}