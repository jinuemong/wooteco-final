package christmas.domain

import christmas.domain.model.Menu

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

    fun getOrderMenuPrice(menu: Menu): Int {
        return menus[menu]?.let {
            return it * menu.getMenuPrice()
        } ?: 0
    }
}